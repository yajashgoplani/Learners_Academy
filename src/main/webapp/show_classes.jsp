<%@page import="java.util.List"%>
<%@page import="entity.classes"%>
<%@page import="util.HibernateX"%>
<%@page import="org.hibernate.Session"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<h3>List of All Classes :-</h3>
<br>

<table  border="5px" style="text-align: center;" >
<tr><td>S.No</td><td>Class Id</td><td>Class Name</td></tr>

<%Session ses=HibernateX.getsession(); List<classes> classlist=ses.createNativeQuery("select * from classes",classes.class).getResultList();%>
<%if(classlist==null) { %>
<tr><td colspan="5"><h3 style="color:red">No Classes in the Database</h3></td></tr>
<%} else { int x=1; %>
		<%for(classes s:classlist) { %>
			<tr><td><%=x%></td><td><%=s.getClass_id() %></td><td><%=s.getClassName() %></td></tr>
					<%x++;} %>


<%} %>

</table>


</body>
</html>