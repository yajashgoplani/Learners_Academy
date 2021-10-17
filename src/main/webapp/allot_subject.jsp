<%@page import="org.hibernate.Session"%>
<%@page import="util.HibernateX"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.class_subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign teacher</title>
</head>
<body>
<%
if(request.getSession(false).getAttribute("username")==null)
	response.sendRedirect("login.jsp");
%>
<%@include file="header.jsp" %>
<h3>List of subjects assigned to Class :-</h3>
<h2 style='color:red;font-weight:bold;' id="errorspace"></h2>
<% String class_section=String.valueOf(request.getParameter("selectedsectionforstudents")); %>
<% String class_standard=String.valueOf(request.getParameter("selectedclassforstudents")); %>
<% String probe_query_unassigned=String.format("select class_subject.subject_id,class_subject.class_section,class_subject.class_standard,subject.subjectName,class_subject.id from class_subject INNER JOIN subject ON class_subject.subject_id = subject.id  where class_subject.class_section = \'%s\' and class_subject.class_standard= \'%s\' and class_subject.teacher_id IS NULL ",class_section,class_standard); %>
<% String probe_query_free_teachers="select id,Name from teacher"; %>
<br>
<h3>Class Standard:<%= class_standard %></h3>
<h3>Class Section:<%= class_section %></h3>
<h4>List of Assigned subjects for class having no teachers :-</h4>
<form action="assignteacherservlet">
<table  border="5px" style="text-align: center;" >
<tr><td>S.No</td><td>Subject ID</td><td>Class Section</td><td>Class Standard</td><td>Subject Name</td><td>Select here</td></tr>
<% 
	Session ses=HibernateX.getsession();
	List<Object[]> unassignedsubjectlist=ses.createNativeQuery(probe_query_unassigned).getResultList();
%>
<%if(unassignedsubjectlist.isEmpty()) { %>
<tr><td colspan="5"><h3 style="color:red">No Subjects for the specified Class </h3></td></tr>

<%} else { 
	for (int i = 0; i < unassignedsubjectlist.size(); i++) 
	{%>
	  <tr><td><%=i+1%></td><td><%=unassignedsubjectlist.get(i)[0]%></td><td><%=unassignedsubjectlist.get(i)[1]%></td><td><%=unassignedsubjectlist.get(i)[2]%></td><td><%=unassignedsubjectlist.get(i)[3]%></td><td><input type="radio" name="subjectid" value="<%=unassignedsubjectlist.get(i)[4]%>"></td></tr>
	<%}
}

%>
</table>
<br>
<h4>List of assignable Teachers :-</h4>
<table  border="5px" style="text-align: center;" >
<tr><td>S.No</td><td>Teacher ID</td><td>Teacher Name</td><td>Select here</td></tr>

<% 
	//Session ses=HibernateX.getsession();
	List<Object[]> unassignedteacherlist=ses.createNativeQuery(probe_query_free_teachers).getResultList();
%>
<%if(unassignedteacherlist.isEmpty()) { %>
<tr><td colspan="5"><h3 style="color:red">No Teachers available</h3></td></tr>

<%} else { 
	for (int i = 0; i < unassignedteacherlist.size(); i++) 
	{%>
	  <tr><td><%=i+1%></td><td><%=unassignedteacherlist.get(i)[0]%></td><td><%=unassignedteacherlist.get(i)[1]%></td><td><input type="radio" name="teacherid" value="<%=unassignedteacherlist.get(i)[0]%>"></td></tr>
	<%}
}

%>
</table>
<input type="hidden" name="selectedstandard" value=<%=class_standard%> >
<input type="hidden" name="selectedsection" value=<%=class_section%>> 
<br>
<button type="submit" style="color:blue;font-size: 25px;font-weight: bold;">Assign Selected Teacher</button>

</form>
</body>
</html>