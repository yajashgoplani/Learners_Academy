<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class Report</title>
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
<h3>Class Report :-</h3>
<br>
<h2 style='color:red;font-weight:bold;' id="errorspace"></h2>
<form id="myform" name="myform" method="post" action="generate_report.jsp">

<h2>Select the Class And Section for the generating report:-</h2>

<h3 style="color:blue;">Select Standard</h3>
<select name="selectedclassforstudents" required="required">
<option value="">Select Here</option>
<option value="I">I</option>
<option value="II">II</option>
<option value="III">III</option>
<option value="IV">IV</option>
<option value="V">V</option>
<option value="VI">VI</option>
<option value="VII">VII</option>
<option value="VIII">VIII</option>
<option value="IX">IX</option>
<option value="X">X</option>
<option value="XI">XI</option>
<option value="XII">XII</option>
</select>

<h3 style="color:blue;">Select Section</h3>
<select name="selectedsectionforstudents" required="required">
<option value="">Select Here</option>
<option value="A">A</option>
<option value="B">B</option>
<option value="C">C</option>
</select>
<br>
<br>

<button type="submit" style="color:blue;font-size: 25px;font-weight: bold;">Generate Class Report</button>

</form>


<br>
<br>
<br>
<br>
<br>
<br>
</body>
</html>