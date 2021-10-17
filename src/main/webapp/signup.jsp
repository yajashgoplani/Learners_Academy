<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
<style>
form
{
	margin-left:410px;
	padding: 20px;
	padding-bottom:50px;
	text-align:center;
	margin-right:410px;
	background-color: pink;
	justify-content: center
}
</style>
</head>
<body>
	<h3>Enter your details:</h3>
	<form action="<%=request.getContextPath()%>/SignUp" method="post">
			<div class="form-group">
                <label for="first_name">First Name:</label> <input type="text"
                    class="form-control" id="first_name" placeholder="First Name"
                    name="firstname" required>
            </div>
            <div class="form-group">
                <label for="last_name">Last Name:</label> <input type="text"
                    class="form-control" id="last_name" placeholder="Last Name"
                    name="lastname" required>
            </div>
            <div class="form-group">
                <label for="user_name">User Name:</label> <input type="text"
                    class="form-control" id="user_name" placeholder="User Name"
                    name="username" required>
            </div>
            <div class="form-group">
                <label for="password">New Password:</label> <input type="password"
                    class="form-control" id="newpassword" placeholder="New Password"
                    name="newpassword" required>
            </div>
            <div class="form-group">
                <label for="repassword">Retype Password:</label> <input type="password"
                    class="form-control" id="repassword" placeholder="Confirm Password"
                    name="repassword" required>
            </div>
            
            
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
</body>
</html>