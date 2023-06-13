<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style type="text/css">
.navbar {
	width: 100%;
	height: 15vh;
	margin: auto;
	display: flex;
	align-items: center;
}

nav {
	flex: 1;
	padding-left: 60%;
}

nav ul li {
	display: inline-block;
	list-style: none;
	margin: 0 15px;
}

nav ul li a {
	text-decoration: none;
	color: #000000;
	text-transform: uppercase;
	font-size: 15px;
	font-weight: 600;
}

nav ul li a:hover {
	color: #F81818;
	transition: all .5s;
}
</style>
</head>
<body>
	<div class="navbar">
		<nav>
			<ul>
				<li><form action="listofusers">
						<input type="submit" value="List">
					</form></li>
				<li><a href="home.jsp">Register</a></li>
				<li><a href="update.jsp">Update Name</a></li>
				<li><a href="find.jsp">Find By Email</a></li>
				<li><a href="delete.jsp">Delete</a></li>

			</ul>
		</nav>
	</div>
	<form action="register">
		<h1 align="center">Register Form</h1>
		<div align="center">

			<div>
				<label>Name:</label> <input type="text"
					placeholder="Enter your Name" name="name">
			</div>
			<br>
			<div>
				<label>Email:</label> <input type="email"
					placeholder="Enter your Email" name="email">
			</div>
			<br>
			<div>
				<label>Mobile Number:</label> <input type="tel"
					placeholder="Enter your Mobile Number" name="phone">
			</div>
			<br>
			<div>
				<label>Password:</label> <input type="password"
					placeholder="Enter your Password" name="password">
			</div>
			<br>
			<div>
				<input type="submit" value="Register">
			</div>
	</form>
</body>
</html>
