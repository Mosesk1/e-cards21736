package rw.ecards.model;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.moses.Model.Item;

import rw.ecards.Controller.DbConnection;
import rw.ecards.domain.AtmCard;



public class AtmDao {

public static void saveAtm(String cardNumber, String cardType, String customerNames, LocalDate issueDate, LocalDate validUntil) {
	
		try (Connection con=DbConnection.getConnected()){
			String QUERY="INSERT INTO atmcards (cardNumber,  cardType,  customerNames,  issueDate,  validUntil) values (?,?,?,?,?)";
			
			PreparedStatement statement=con.prepareStatement(QUERY);
			statement.setString(1, cardNumber);
			statement.setString(2, cardType);
			statement.setString(3, customerNames);
			statement.setDate(4, Date.valueOf(issueDate));
			statement.setDate(5, Date.valueOf(validUntil));
			statement.execute();
			System.out.println("Inserted successfully");
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
	
}
public  List<AtmCard> getAllAtm(){
	List<AtmCard> atmList=new ArrayList<>();
	try (Connection con=DbConnection.getConnected()){
		String sql_get_all_atms="SELECT * FROM atmcards";
		
		PreparedStatement statement=con.prepareStatement(sql_get_all_atms);
		
		ResultSet rs= statement.executeQuery();
		while(rs.next()) {
			String cardNumber=rs.getString(1);
			 String cardType=rs.getString(2);
			 String customerNames=rs.getString(3);
			 LocalDate issueDate=rs.getDate(4).toLocalDate();
			 LocalDate validUntil=rs.getDate(5).toLocalDate();
			 String status=rs.getString(6);
			 
			 AtmCard atm=new AtmCard(cardNumber, cardType, customerNames, issueDate, validUntil,status);
			 atmList.add(atm);
		
			
		}
		
	} catch (Exception ex) {
		
		ex.printStackTrace();
	}
return atmList;
	

}
public static Item getItemById(int id) throws SQLException {
	
	Item item = new Item();
	
	Connection con=DbConnection.getConnected();
	
	String query = "SELECT * FROM clothingItems WHERE code =?";
	
	PreparedStatement statement=con.prepareStatement(query);
	statement.setInt(1, id);
	
	ResultSet r= statement.executeQuery();
	
	while(r.next()) {
		 int code=r.getInt(1);
		 String name=r.getString(2);
		 String brandUnit=r.getString(3);
		 Double unitPrice=r.getDouble(4);
		 String quantity=r.getString(5);
		 LocalDate registrationDate=r.getDate(6).toLocalDate();
		 
		item=new Item(code,  name,  brandUnit,  unitPrice,  quantity,  registrationDate);
		
	
		
	}
	
	
	return item;
}


}
