<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
.form-group1 a
{
	display: inline;
	float: left;
}
.form-group1 button
{
	
	display: inline;
	float: right;
}
</style>
</head>
<body>
	<h1>Welcome to Learners Academy</h1>
	<form action="loginservlet" method="post">
            <div class="form-group">
                <label for="user_name">User Name:</label> <input type="text"
                    class="form-control" id="user_name" placeholder="User Name"
                    name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label> <input type="password"
                    class="form-control" id="password" placeholder="Password"
                    name="password" required>
            </div>
            <br><br>
            <div class="form-group1">
            <a href="signup.jsp">SignUp</a>
           
            <button type="submit" class="btn btn-primary">Submit</button>
             </div>
       </form>
</body>
</html>