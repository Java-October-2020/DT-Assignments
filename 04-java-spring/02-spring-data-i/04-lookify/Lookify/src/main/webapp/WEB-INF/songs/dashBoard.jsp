<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" type = "text/css" href = "css/style.css">
</head>
<body>
<h1>All Songs</h1>
<br>
	<div class="container">
	<nav>
		<p class = "links"><a href="/add">Add New Song</a> </p><p><a href="/topTen">Top Songs</a></p>
		
		<form action="/search/${id}" class="float-center">
		<input type="text" name="artist">
		<button class="btn btn-primary">Search Artist</button>
		</form>
	</nav>
<table class="table table-hover table-dark"> 
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
   			<td><a href = "<c:url value = "/delete/${thisSong.id}"/>">delete</a> <a href = "/edit/${thisSong.id}">edit</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

	 											
</div>
<!--  <br><a href="/add">New Song</a>  -->
</body>
</html>