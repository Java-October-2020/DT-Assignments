<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" type = "text/css" href = "css/style.css">
</head>
<body>
	<div class="container">
		<nav>
			<h3>Searched for: ${artist}</h3>
			<form action="/search">
			<input type="text" name="artist"/>
			<button class="btn btn-primary">Search Artist</button>
			</form>
			<a class="float-right" href="/dashBoard">Dashboard</a>
		</nav>
		<table class="table table-dark">
	    <thead>
	        <tr>
	            <th>Title</th>
	            <th>Artist</th>
	            <th>Rating</th>
	            <th>Action</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${song}" var="thisSong">  <!-- needs to be different names -->
	        <tr>  
	        	<td><a href = "/showOne/${thisSong.id}">${thisSong.title}</a></td>
	            <td><c:out value="${thisSong.artist}"/></td>
	            <td><c:out value="${thisSong.rating}"/></td>
	   			<td><a href = "<c:url value = "/delete/${thisSong.id}"/>">delete</a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>

	</div>

</body>
</html>