<%@page import="org.hibernate.Session"%>
<%@page import="util.HibernateX"%>
<%@page import="java.util.List"%>
<%@page import="entity.teacher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teachers</title>
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
<h3>List of All Teachers :-</h3>
<br>

<table  border="5px" style="text-align: center;" >
<tr><td>S.No</td><td>Teacher Id</td><td>Teacher Name</td><td>Teacher Phone</td><td>Teacher DOB</td><td>Teacher Gender</td></tr>

<%Session ses=HibernateX.getsession(); List<teacher> teacherlist=ses.createNativeQuery("select * from teacher",teacher.class).getResultList();%>
<%if(teacherlist==null) { %>
<tr><td colspan="5"><h3 style="color:red">No Students in the Database</h3></td></tr>
<%} else { int x=1; %>
		<%for(teacher s:teacherlist) { %>
			<tr><td><%=x%></td><td><%=s.getId()%></td><td><%=s.getName() %></td><td><%=s.getPhoneno() %></td><td><%=s.getDOB() %></td><td><%=s.getGender()%></td></tr>
					<%x++;} %>


<%} %>

</table>

</body>
</html>