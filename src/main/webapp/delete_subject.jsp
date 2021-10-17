<%@page import="entity.subject"%>
<%@page import="java.util.List"%>
<%@page import="util.HibernateX"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete subject</title>
</head>
<body>
<%
if(request.getSession(false).getAttribute("username")==null)
	response.sendRedirect("login.jsp");
%>
<%@ include file = "header.jsp" %>
<h1>Delete Subject</h1>

<table  border="5px" style="text-align: center;" >
<tr><td>S.No</td><td>Subject Id</td><td>Subject Name</td><td>Intended Class</td><td>Press to Delete</td></tr>

<%Session ses=HibernateX.getsession(); List<subject> subjectlist=ses.createNativeQuery("select * from subject",subject.class).getResultList();%>
<%if(subjectlist==null) { %>
<tr><td colspan="5"><h3 style="color:red">No Subjects in the Database</h3></td></tr>
<%}else if(subjectlist.isEmpty()){%>
	<tr><td colspan="7"><h3 style="color:red">No Subjects in the Database</h3></td></tr>
<%} else { int x=1; %>
		<%for(subject s:subjectlist) { %>
			<form action="deletesubjectservlet">
			<input type="hidden" value="<%=s.getId()%>" name="subject_id">
			<tr><td><%=x%></td><td><%=s.getId()%></td><td><%=s.getSubjectName() %></td><td><%=s.getSubjectForClass() %></td><td><button type="submit">Delete</button></td></tr>
			</form>
					<%x++;} %>


<%} %>

</table>

<form action="deletesubjectservlet">
<h4>Enter Subject ID</h4>
<input type="number" name="subject_id" placeholder="Subject ID" min="0" max="2147483646" required>
<br/>
<input type="submit" value="Delete Subject">

</form>
</body>
</html>