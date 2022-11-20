<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apna Bank</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>
<div>
	<h1>Apna Bank</h1>
	<h2> Perform action </h2>
	<form action="deposite.jsp">
	<input type="submit" value="deposite money">
	</form><br>
	<form action="withdraw.jsp">
	<input type="submit" value="withdraw money">
	</form><br>
	<form action="Balance">
	<input type="submit" value="view balance">
	</form><br>
	<form action="MyProfile">
	<input type="submit" value="MyProfile">
	</form><br>
	<form action="Logoutaccount">
	<input type="submit" value="Logout">
	</form>
	
</div>
</body>
</html>