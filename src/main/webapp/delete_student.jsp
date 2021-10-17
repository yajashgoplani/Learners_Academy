<%@page import="entity.student"%>
<%@page import="java.util.List"%>
<%@page import="util.HibernateX"%>
<%@page import="org.hibernate.Session"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Student</title>
</head>
<body>
<%
if(request.getSession(false).getAttribute("username")==null)
	response.sendRedirect("login.jsp");
%>
<%@ include file = "header.jsp" %>
<h1>Delete Student</h1>

<table  border="5px" style="text-align: center;" >
<tr><td>S.No</td><td>Student Id</td><td>Student Name</td><td>Student Phone</td><td>Student DOB</td><td>Student Gender</td><td>Press to Delete</td></tr>

<%Session ses=HibernateX.getsession(); List<student> teacherlist=ses.createNativeQuery("select * from student",student.class).getResultList();%>
<%if(teacherlist==null) { %>
<tr><td colspan="5"><h3 style="color:red">No Teachers in the Database</h3></td></tr>
<%}else if(teacherlist.isEmpty()){%>
	<tr><td colspan="7"><h3 style="color:red">No Teachers in the Database</h3></td></tr>
<%} else { int x=1; %>
		<%for(student s:teacherlist) { %>
			<form action="deletestudentservlet">
			<input type="hidden" value="<%=s.getId()%>" name="student_id">
			<tr><td><%=x%></td><td><%=s.getId()%></td><td><%=s.getName() %></td><td><%=s.getPhoneno() %></td><td><%=s.getDOB() %></td><td><%=s.getGender()%></td><td><button type="submit">Delete</button></td></tr>
			</form>
					<%x++;} %>


<%} %>

</table>

<form action="deletestudentservlet">
<h4>Enter Student ID</h4>
<input type="number" name="student_id" placeholder="Student ID" min="0" max="2147483646" required>
<br/>
<input type="submit" value="Delete Student">

</form>
</body>
</html>