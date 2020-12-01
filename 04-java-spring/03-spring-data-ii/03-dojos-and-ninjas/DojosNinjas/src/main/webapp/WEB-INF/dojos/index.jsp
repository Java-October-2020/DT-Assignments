<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos and Ninjas Page</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
		<h1>Dojos and Ninjas</h1>
		<a href="/ninjas">Display Ninja(s)</a> | 
		<a href="/dojos/new">Add Dojo</a>
		<hr />
		<h2>All Dojos</h2> <h6>(Select Dojo for list of Ninja members)</h6>
		<ul>
		<c:forEach items="${ dojos }" var="dojo">
			<li><a href="/dojos/${ dojo.id }">${ dojo.name }</a></li>
		</c:forEach>
		</ul>	
	</div>
</body>
</html>