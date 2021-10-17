<%@page import="org.hibernate.Session"%>
<%@page import="util.HibernateX"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign student to class</title>
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
<h3>Students to be Assigned :-</h3>
<br>
<h2 style='color:red;font-weight:bold;' id="errorspace"></h2>
<form action="assignstudentservlet">

<table  border="5px" style="text-align: center;" >
<tr><td>S.No</td><td>Select here</td><td>Student Id</td><td>Student Name</td><td>Student Phone</td><td>Student DOB</td><td>Student Gender</td></tr>

<%List<student> unassignedstudentlist=new ArrayList<>(); 
	Session ses=HibernateX.getsession();
	unassignedstudentlist=ses.createNativeQuery("select * from student where id not in (select student_id from class_students)", student.class)
			.getResultList();		
%>
<%if(unassignedstudentlist.isEmpty()) { %>
<tr><td colspan="5"><h3 style="color:red">No Students in the Database</h3></td></tr>
<%} else { int x=1; %>
		<%for(student s:unassignedstudentlist) { %>
			<tr><td><%=x%></td><td><input type="checkbox" name="assignstudentids" value="<%=s.getId()%>"></td><td><%=s.getId()%></td><td><%=s.getName() %></td><td><%=s.getPhoneno() %></td><td><%=s.getDOB() %></td><td><%=s.getGender()%></td></tr>
					<%x++;} %>


<%} %>

</table>

<h2>Select the Class And Section for the selected Students</h2>

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

<button type="submit" style="color:blue;font-size: 25px;font-weight: bold;">Assign Selected Students</button>

</form>


<br>
<br>
<br>

<br>
<br>
<br>
<br>



</body>
</html>