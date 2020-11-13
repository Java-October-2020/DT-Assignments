<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top Ten</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h2>Top Ten Songs by Rating</h2>
		<a class="float-right" href="/dashBoard">Dashboard</a>
		<table class="table table-hover table-dark">
	    <thead>
	        <tr>
	            <th>Rating</th>
	            <th>Title</th>
	            <th>Artist</th>
	            <th>Action</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${song}" var="thisSong">  <!-- needs to be different names -->
	        <tr>  
	        	<td><c:out value="${thisSong.rating}"/></td>
	        	<td><a href = "/showOne/${thisSong.id}">${thisSong.title}</a></td>
	            <td><c:out value="${thisSong.artist}"/></td>
	   			<td><a href = "/edit/${thisSong.id}">edit</a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
</div>
</body>
</html>