<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<title>New Song</title>
</head>
<body>
<div class = "container">

<h1>Add a New Song</h1>				<a class="float-right" href="/dashBoard">Dashboard</a>
<form:form action="/add" method="post" modelAttribute="song">
    <div>
        <form:label path="title">Song Title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </div>
    <div>
        <form:label path="artist">Artist</form:label>
        <form:errors path="artist"/>
        <form:textarea path="artist"/>
    </div>
    <div>
        <form:label path="rating">Rating</form:label>
        <form:errors path="rating"/>
        <form:input path="rating"/>
    </div>
  
    <input type="submit" value="Add Song"/>
</form:form> 

</div>   
</body>
</html>