<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Book </title>
 <link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
 
<h1>New Book</h1>

<div class = "container">
<form action="/add" method="POST">    <!-- Post method takes from front-end and sends to back-end -->
<div class="form-group">
<label for="bookTitle">Book Title:</label>
<input type="text" name="bookTitle">
</div>

<div class="form-group">
<label for="author">Author:</label>
<input type="text" name="author">
</div>

<div class="form-group">
<label for="description">Description:</label>
<input type="text" name="description">
</div>

<div class="form-group">
<label for="language">Language:</label>
<input type="text" name="language">
</div>

<div class="form-group">
<label for="numberOfPages">Number of pages:</label>
<input type="text" name="numberOfPages">
</div>

<input type="submit" value="Submit"/>
</form>
</div>  <!--  end of container -->


<!--  This section should really be used. the above is the non-JPA way
<form:form action="/books" method="post" modelAttribute="book">
    <p>
        <form:label path="bookTitle">Title</form:label>
        <form:errors path="bookTitle"/>
        <form:input path="bookTitle"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="language">Language</form:label>
        <form:errors path="language"/>
        <form:input path="language"/>
    </p>
    <p>
        <form:label path="numberOfPages">Pages</form:label>
        <form:errors path="numberOfPages"/>     
        <form:input type="number" path="numberOfPages"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>
															-->

</body>
</html>