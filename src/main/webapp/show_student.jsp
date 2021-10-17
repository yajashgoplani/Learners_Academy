<%@page import="java.util.List"%>
<%@page import="entity.student"%>
<%@page import="util.HibernateX"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Students</title>
</head>
<body>
<%
if(request.getSession(false).getAttribute("username")==null)
	response.sendRedirect("login.jsp");
%>
<%@include file="header.jsp" %>

<br>
<br>
<br>
<h3>List of All Students :-</h3>
<br>

<table  border="5px" style="text-align: center;" >
<tr><td>S.No</td><td>Student Id</td><td>Student Name</td><td>Student Phone</td><td>Student DOB</td><td>Student Gender</td></tr>

<%Session ses=HibernateX.getsession(); List<student> studentlist=ses.createNativeQuery("select * from student",student.class).getResultList();%>
<%if(studentlist==null) { %>
<tr><td colspan="5"><h3 style="color:red">No Students in the Database</h3></td></tr>
<%} else { int x=1; %>
		<%for(student s:studentlist) { %>
			<tr><td><%=x%></td><td><%=s.getId()%></td><td><%=s.getName() %></td><td><%=s.getPhoneno() %></td><td><%=s.getDOB() %></td><td><%=s.getGender()%></td></tr>
					<%x++;} %>


<%} %>

</table>



</body>
</html>