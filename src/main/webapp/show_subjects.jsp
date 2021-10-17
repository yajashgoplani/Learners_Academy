<%@page import="java.util.List"%>
<%@page import="entity.subject"%>
<%@page import="util.HibernateX"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subjects</title>
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
<h3>List of All Subjects :-</h3>
<br>

<table  border="5px" style="text-align: center;" >
<tr><td>S.No</td><td>Subject Name</td><td>Intended Class</td></tr>

<%Session ses=HibernateX.getsession(); List<subject> subjectlist=ses.createNativeQuery("select * from subject",subject.class).getResultList();%>
<%if(subjectlist==null) { %>
<tr><td colspan="5"><h3 style="color:red">No Students in the Database</h3></td></tr>
<%} else { int x=1; %>
		<%for(subject s:subjectlist) { %>
			<tr><td><%=x%></td><td><%=s.getSubjectName()%></td><td><%=s.getSubjectForClass()%></td></tr>
					<%x++;} %>


<%} %>

</table>

</body>
</html>