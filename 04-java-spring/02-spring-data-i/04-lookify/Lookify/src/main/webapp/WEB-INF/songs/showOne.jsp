<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
	<div class="oneSong">
		<a class="float-right" href="/dashBoard">Dashboard</a>
			<h3>Song Title: </h3>
			<p>${song.title}</p>
			<h3>Artist: </h3>
			<p>${song.artist}</p>
			<h3>Rating: </h3>
			<p>${song.rating}</p>
			<form action="/songs/${song.id}" method="post">
				<input type="hidden" name="_method" value="delete"/>
				<input class="btn btn-danger" type="submit" value="Delete"/>
			</form>
			
	</div>

</body>
</html>