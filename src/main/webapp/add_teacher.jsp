<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
<%
if(request.getSession(false).getAttribute("username")==null)
	response.sendRedirect("login.jsp");
%>
<%@ include file = "header.jsp" %>
<h1>Add Teacher</h1>

<form action="addteacherservlet">
<h4>Enter Teacher Name</h4>
<input type="text" name="teacher_name" placeholder="Teacher Name" required>
<h4>Select Date of Birth</h4>
<input type="date" name="teacher_dob" required>
<h4>Enter Phone No</h4>
<input type="number" name="teacher_phoneno" placeholder="Phone Number" required>
<h4>Select Gender</h4>
<select name="teacher_gender" required>
<option>Select</option>
<option value="male">Male</option>
<option value="female">Female</option>
</select>
<br/>
<input type="submit" value="Add Teacher">

</form>
</body>
</html>