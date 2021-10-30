package rw.ecards.model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CardRegistrationServ
 */
@WebServlet("/CardRegistrationServ")
public class CardRegistrationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, String> errors;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardRegistrationServ() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		errors = new HashMap<>();
		//PrintWriter out = response.getWriter();
		
		String cardNumber=request.getParameter("cardNumber");
		String cardType=request.getParameter("cardType");
		String customerNames=request.getParameter("customerNames");
		LocalDate issueDate= LocalDate.now();
		LocalDate validUntil=LocalDate.parse(request.getParameter("validUntil"));
		
		if(!cardNumber.matches("[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}")) {
			errors.put("carderror", "must be 16 digits separetated by space");
			
			//out.println("error");
		}
		
         if(!errors.isEmpty()) {
			
			request.getSession().setAttribute("errors", errors);
			response.sendRedirect("cardRegistrationForm.jsp");
		}

         else {
		AtmDao.saveAtm(cardNumber, cardType, customerNames, issueDate, validUntil);
		
		response.sendRedirect("userList.jsp");
         }
	}

}
