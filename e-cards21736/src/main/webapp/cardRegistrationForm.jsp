<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	Map<String, String> errors = (Map) session.getAttribute("errors");
    	pageContext.setAttribute("error", errors);
    	session.removeAttribute("errors");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ATM cards management system</title>
</head>
<body>
<a href="/e-cards21736/userList.jsp">User List</a>
<h2>ATM cards management system  </h2>

<form action="CardRegistrationServ" method="post">
 <label>card Number:  </label>
 <input type="text" name="cardNumber"  placeholder="Enter your cardNumber "><label>${error["carderror"]}</label>
 <br>
 <br>
 card Type : <select name="cardType">
			<option>VISA CARD</option>
			<option>MASTER CARD</option>
			<option>UNIONPAY CARD</option>
			
		</select><br><br>

 <label>customer Names:</label>
 <input type="text" name="customerNames"  placeholder="Enter your authors">
 <br>
 <br>
 <label>valid Until</label>
 <input type="date" name="validUntil"  placeholder="Enter your publicationYear">
 <br>
 <br>
 <input type="submit" value="SAVE">

</form>

</body>
</html>