<%@page import="entity.teacher"%>
<%@page import="java.util.List"%>
<%@page import="util.HibernateX"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Teacher</title>
</head>
<body>
<%
if(request.getSession(false).getAttribute("username")==null)
	response.sendRedirect("login.jsp");
%>
<%@ include file = "header.jsp" %>
<h1>Delete Teacher</h1>

<table  border="5px" style="text-align: center;" >
<tr><td>S.No</td><td>Teacher Id</td><td>Teacher Name</td><td>Teacher Phone</td><td>Teacher DOB</td><td>Teacher Gender</td><td>Press to Delete</td></tr>

<%Session ses=HibernateX.getsession(); List<teacher> teacherlist=ses.createNativeQuery("select * from teacher",teacher.class).getResultList();%>
<%if(teacherlist==null) { %>
<tr><td colspan="5"><h3 style="color:red">No Teachers in the Database</h3></td></tr>
<%}else if(teacherlist.isEmpty()){%>
	<tr><td colspan="7"><h3 style="color:red">No Teachers in the Database</h3></td></tr>
<%} else { int x=1; %>
		<%for(teacher s:teacherlist) { %>
			<form action="deleteteacherservlet">
			<input type="hidden" value="<%=s.getId()%>" name="teacher_id">
			<tr><td><%=x%></td><td><%=s.getId()%></td><td><%=s.getName() %></td><td><%=s.getPhoneno() %></td><td><%=s.getDOB() %></td><td><%=s.getGender()%></td><td><button type="submit">Delete</button></td></tr>
			</form>
					<%x++;} %>


<%} %>

</table>

<form action="deleteteacherservlet">
<h4>Enter Teacher ID</h4>
<input type="number" name="teacher_id" placeholder="Teacher ID" min="0" max="2147483646" required>
<br/>
<input type="submit" value="Delete Teacher">

</form>
</body>
</html>