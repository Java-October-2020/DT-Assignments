<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
		<h1>${ persons.firstName } ${ persons.lastName }</h1>
		<p><strong>License Number</strong> ${ persons.license.getNumberAsString() }</p>
		<p><strong>Expiration Date</strong> ${ persons.license.getExpirationDateFormatted() }</p>
	</div>
</body>
</html>