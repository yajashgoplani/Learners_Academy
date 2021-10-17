<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
body
{
	margin:0px;
}
a
{
	margin:20px;
	
	height:50px;
	text-align: center;
	background-color: black;
	color: white;
	padding: 10px;
	font-size: 18px;
	text-decoration: none;
}
.first a
{
display: inline;
width:25%;
float:left;
} 
.second a
{
display: inline;
width:25%;
float:left;
} 
.third a
{
display: inline;
width:18%;
float:left;
} 
.fourth a
{
width:25%;
display: inline;
float:left;
} 
.fifth a
{
width:90%;
display: inline;
float: left;
}
</style>
</head>
<body>
<%@ include file="header.jsp" %>
 
<%
if(request.getSession(false).getAttribute("username")==null)
	response.sendRedirect("login.jsp");
%>

	<% String uname=(String)request.getSession(false).getAttribute("firstname"); 
		out.println("<h1>Welcome "+uname+"</h1>");
	
	%>
	
	<h2 id="messagespace" style="color: green;font-weight: bold;"></h2>
	<div class="first">
	<a href="add_student.jsp">Add Student</a>
	<a href="add_teacher.jsp">Add Teacher</a>
	<a href="add_subject.jsp">Add Subject</a>
	</div>
	<br><br><br><br>
	<div class="second">
	<a href="delete_student.jsp">Remove Student</a>
	<a href="delete_teacher.jsp">Remove Teacher</a>
	<a href="delete_subject.jsp">Remove Subject</a>
	</div>
	<br><br><br><br>
	<div class="third">
	<a href="show_student.jsp">Show All Students</a>
	<a href="show_teacher.jsp">Show All Teachers</a>
	<a href="show_subjects.jsp">Show All Subjects</a>
	<a href="show_classes.jsp">Show All Class</a>
	</div>
	<br><br><br><br>
	<div class="fourth">
	<a href="assign_student.jsp">Assign Students to Class</a>
	<a href="assign_teacher.jsp">Assign Teachers to Class</a>
	<a href="assign_subject.jsp">Assign Subjects to Class</a>
	</div>
	<br><br><br><br>
	<div class="fifth">
	<a href="class_report.jsp">Class Report</a>
	</div>
</body>
</html>