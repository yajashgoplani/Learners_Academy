<%@page import="org.hibernate.Session"%>
<%@page import="util.HibernateX"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.subject"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign subject to Class</title>
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
<h3>Subjects to be Assigned :-</h3>
<br>
<h2 style='color:red;font-weight:bold;' id="errorspace"></h2>
<form action="assignsubjectservlet">

<table  border="5px" style="text-align: center;" >
<tr><td>S.No</td><td>Select here</td><td>Subject Id</td><td>Subject Name</td><td>Intended Class</td></tr>

<%List<subject> unassignedsubjectlist=new ArrayList<>(); 
	Session ses=HibernateX.getsession();
	unassignedsubjectlist=ses.createNativeQuery("select * from subject where id not in (select subject_id from class_subject)", subject.class)
			.getResultList();		
%>
<%if(unassignedsubjectlist.isEmpty()) { %>
<tr><td colspan="5"><h3 style="color:red">No Subjects in the Database</h3></td></tr>
<%} else { int x=1; %>
		<%for(subject s:unassignedsubjectlist) { %>
			<tr><td><%=x%></td><td><input type="checkbox" name="assignsubjectids" value="<%=s.getId()%>"></td><td><%=s.getId() %></td><td><%=s.getSubjectName() %></td><td><%=s.getSubjectForClass() %></td></tr>
					<%x++;} %>


<%} %>

</table>

<h2>Select the Class And Section for the selected Subjects</h2>

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

<button type="submit" style="color:blue;font-size: 25px;font-weight: bold;">Assign Selected Subjects</button>

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