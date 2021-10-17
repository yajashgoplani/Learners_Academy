<%@page import="org.hibernate.Session"%>
<%@page import="util.HibernateX"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.class_students"%>
<%@page import="java.util.List"%>

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
<h3>Class Report :-</h3>
<h2 style='color:red;font-weight:bold;' id="errorspace"></h2>
<% String class_section=String.valueOf(request.getParameter("selectedsectionforstudents")); %>
<% String class_standard=String.valueOf(request.getParameter("selectedclassforstudents")); %>
<% String probe_query_student=String.format("select class_students.class_section,class_students.class_standard,student.Name from class_students INNER JOIN student ON class_students.student_id=student.id where class_students.class_section = \'%s\' and class_students.class_standard=\'%s\'",class_section,class_standard); %>
<% String probe_query_subject=String.format("select class_subject.class_section,class_subject.class_standard,subject.subjectName from class_subject INNER JOIN subject ON class_subject.subject_id=subject.id where class_subject.class_section = \'%s\' and class_subject.class_standard=\'%s\'",class_section,class_standard); %>
<% String probe_query_teacher=String.format("select class_subject.class_section,class_subject.class_standard,subject.subjectName,teacher.Name from class_subject INNER JOIN subject ON class_subject.subject_id = subject.id INNER JOIN teacher ON class_subject.teacher_id = teacher.id where class_subject.class_section = \'%s\' and class_subject.class_standard= \'%s\' ",class_section,class_standard); %>
<br>
<h3>Class Standard:<%= class_standard %></h3>
<h3>Class Section:<%= class_section %></h3>
<h4>List of Students :-</h4>
<table  border="5px" style="text-align: center;" >
<tr><td>S.No</td><td>Class Section</td><td>Class Standard</td><td>Student Name</td></tr>

<% 
	Session ses=HibernateX.getsession();
	List<Object[]> assignedstudentlist=ses.createNativeQuery(probe_query_student).getResultList();
%>
<%if(assignedstudentlist.isEmpty()) { %>
<tr><td colspan="5"><h3 style="color:red">No Students in the Database</h3></td></tr>

<%} else { 
	for (int i = 0; i < assignedstudentlist.size(); i++) 
	{%>
	  <tr><td><%=i+1%></td><td><%=assignedstudentlist.get(i)[0]%></td><td><%=assignedstudentlist.get(i)[1]%></td><td><%=assignedstudentlist.get(i)[2]%></td></tr>
	<%}
}

%>
</table>
<br>
<h4>List of Subjects :-</h4>
<table  border="5px" style="text-align: center;" >
<tr><td>S.No</td><td>Class Section</td><td>Class Standard</td><td>Subject Name</td></tr>

<% 
	//Session ses=HibernateX.getsession();
	List<Object[]> assignedsubjectlist=ses.createNativeQuery(probe_query_subject).getResultList();
%>
<%if(assignedsubjectlist.isEmpty()) { %>
<tr><td colspan="5"><h3 style="color:red">No Subjects in the Database</h3></td></tr>

<%} else { 
	for (int i = 0; i < assignedsubjectlist.size(); i++) 
	{%>
	  <tr><td><%=i+1%></td><td><%=assignedsubjectlist.get(i)[0]%></td><td><%=assignedsubjectlist.get(i)[1]%></td><td><%=assignedsubjectlist.get(i)[2]%></td></tr>
	<%}
}

%>
</table>
<br>
<h4>List of Teachers :- </h4>
<table  border="5px" style="text-align: center;" >
<tr><td>S.No</td><td>Class Section</td><td>Class Standard</td><td>Teacher Name</td><td>Subject Name</td></tr>

<% 
	//Session ses=HibernateX.getsession();
	List<Object[]> assignedteacherlist=ses.createNativeQuery(probe_query_teacher).getResultList();
%>
<%if(assignedteacherlist.isEmpty()) { %>
<tr><td colspan="5"><h3 style="color:red">No Teachers in the Database</h3></td></tr>

<%} else { 
	for (int i = 0; i < assignedteacherlist.size(); i++) 
	{%>
	  <tr><td><%=i+1%></td><td><%=assignedteacherlist.get(i)[0]%></td><td><%=assignedteacherlist.get(i)[1]%></td><td><%=assignedteacherlist.get(i)[2]%></td><td><%=assignedteacherlist.get(i)[3]%></td></tr>
	<%}
}

%>
</table>

</body>
</html>