<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.example.demo.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of user</title>
</head>
<body>
	<%
	List<User> users = (List<User>) request.getAttribute("USER_LIST");
	%>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Phone Number</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (User user : users) {
			%>
			<tr>
				<td><%=user.getName()%>
				<td><%=user.getEmail()%>
				<td><%=user.getPhone()%>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>8
</body>
</html>