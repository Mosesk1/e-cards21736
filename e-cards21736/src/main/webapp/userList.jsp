<%@page import="rw.ecards.domain.AtmCard"%>
<%@page import="java.util.List"%>
<%@page import="rw.ecards.model.AtmDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTERD CARDS</title>
</head>
<body>
<h1>LIST OF ALL THE REGISTERD CARDS</h1>
<a href="/e-cards21736/cardRegistrationForm.jsp">New Card</a>
<br>
<br>
<%
AtmDao dao = new AtmDao();
List<AtmCard> atmList = dao.getAllAtm();
%>
<table>
<thead>
<tr>
<th>Card Number</th>
<th>Card Type</th>
<th>Customer Names</th>
<th>issueDate</th>
<th>validUntil</th>
<th>Status</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<%
for (AtmCard atm:atmList){ %>
<tr>
<td><%=atm.getCardNumber() %></td>
<td><%=atm.getCardType() %></td>
<td><%=atm.getCustomerNames() %></td>
<td><%=atm.getIssueDate() %></td>
<td><%=atm.getValidUntil() %></td>
<!--<td><a href="updateStatus.jsp?id=<%= atm.getCardNumber() %>>"><%= atm.getStatus() %></a></td> -->
<!--  <td></td>-->
 <td>${card.status}</td>
                       <td> <% if(atm.getStatus().matches("NEW")){ %> </td>
                          <td><a href="updateStatus.jsp?id=<%= atm.getCardNumber() %>"><%= atm.getStatus() %></a>issue</a></td>
                        <%}else if(atm.getStatus().equalsIgnoreCase("issued")){%>
                            <td><a href="updateStatus.jsp?id=<%= atm.getCardNumber() %>"><%= atm.getStatus() %></a>block</a></td>
 
<% } %>
</tr>
<% } %>
</tbody>

</table>
</body>
</body>
</html>