<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update page</title>
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
	<form action="update">
		<h1 align="center">Update User</h1>
		<div align="center">

			<div>
				<label>Email:</label> <input type="email"
					placeholder="Enter your Email" name="email">
			</div>
			<br>
			<div>
				<label>ReName:</label> <input type="text"
					placeholder="Enter your New Name" name="name">
			</div>
			<br>
			<div>
				<input type="submit" value="Update">
			</div>
		</div>
	</form>
</body>
</html>