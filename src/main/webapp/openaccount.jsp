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
<form action="Openaccount" method="post">
<h1>Apna Bank</h1>
<h2>Open an Account</h2>
		<input type="radio" name="user_account" value="current">Current account<br>
		<input type="radio" name="user_account" value="saving">Saving account<br>
		
		<label for="fname">First Name:</label>
		<input type="text" id="fname" name="fname" required="required"><br><br>
		
		<label for="lname">Last Name:</label>
		<input type="text" id="lname" name="lname" required="required"><br><br>
		
		<label for="birthday">Birthday:</label>
		<input type="date" id="birthday" name="birthday"><br><br>
		
		<label for="licenceNumber">LicenceNumber:</label>
		<input type="text" name="licenceNumber"><br><br>
		
		<lable for="pin">PIN Number:</lable>
		<input type="number" id="pin" name="pin"><br><br>
		
		<lable for="Select sequerity question">Select sequerity question</lable>
		<select name="question1">
			<option>Question 1</option>
			<option value="Your first car">Your first car</option>
			<option value="Mother's middle name">Mother's middle name</option>
			<option value="Favourite holiday place">Favourite holiday place</option>
			<option value="Favourite dish">Favourite dish</option>
			<option value="Your lastName">Your LastName</option>
			<option value="Your Born City">Your Born City</option>
			</select>
			<lable for="answer1">Answer1</lable>
			<input type="text"  name="answer1" required="required"><br><br>
			
		<lable for="Select sequerity question">Select sequerity question</lable>
		<select name="question2">
			<option>Question 2</option>
			<option value="Your first car">Your first car</option>
			<option value="Mother's middle name">Mother's middle name</option>
			<option value="Favourite holiday place">Favourite holiday place</option>
			<option value="Favourite dish">Favourite dish</option>
			<option value="Your lastName">Your LastName</option>
			<option value="Your Born City">Your Born City</option>
			</select>
			<lable for="answer2">Answer2</lable>
			<input type="text"  name="answer2" required="required"><br><br>
			
		<lable for="Select sequerity question">Select sequerity question</lable>
		<select name="question3">
			<option>Question 3</option>
			<option value="Your first car">Your first car</option>
			<option value="Mother's middle name">Mother's middle name</option>
			<option value="Favourite holiday place">Favourite holiday place</option>
			<option value="Favourite dish">Favourite dish</option>
			<option value="Your lastName">Your LastName</option>
			<option value="Your Born City">Your Born City</option>
			</select>
			<lable for="answer3">Answer3</lable>
			<input type="text"  name="answer3" required="required"><br><br>
			
		<lable for="Select sequerity question">Select sequerity question</lable>
		<select name="question4">
			<option>Question 4</option>
			<option value="Your first car">Your first car</option>
			<option value="Mother's middle name">Mother's middle name</option>
			<option value="Favourite holiday place">Favourite holiday place</option>
			<option value="Favourite dish">Favourite dish</option>
			<option value="Your lastName">Your LastName</option>
			<option value="Your Born City">Your Born City</option>
			</select>
			<lable for="answer4">Answer4</lable>
			<input type="text"  name="answer4" required="required"><br><br>
			
		<label for="balance">Balance</label>
		<input type="number" name="balance" required="required"><br><br>
			
		<input type="checkbox" value="checked" name="condition" required="required">Agree terms and conditions<br><br>
		<input type="submit" value="Submit">
		<input type="reset" value="Reset">
</form>
</div>
</body>
</html>