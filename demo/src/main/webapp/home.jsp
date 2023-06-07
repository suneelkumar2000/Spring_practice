<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<form action="register">
		<h1 align="center">Welcome</h1>
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
			<br>
			<div>
				<a href="update.jsp">Update Email</a>
			</div>
			<br>
			<div>
				<a href="delete.jsp">Delete</a>
			</div>

		</div>
	</form>
	<div align="center">
		<form action="listofusers">
			<input type="submit" value="List">
		</form>
	</div>
</body>
</html>
