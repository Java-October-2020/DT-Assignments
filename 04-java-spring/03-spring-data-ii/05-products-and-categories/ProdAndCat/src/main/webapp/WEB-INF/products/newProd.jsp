<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Products Page</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class= "table table-dark" id="container">
<nav>
<a href="/">Home Page</a>
</nav>
<h1>Create New Product</h1>
<form:form action="/products/new" method="post" modelAttribute="products">
<p>
<form:label path="name">Products Name</form:label>
<form:errors path ="name"/>
<form:input path="name" type="text"/>
</p>
<p>
<form:label path="description">Products Description</form:label>
<form:errors path ="description"/>
<form:input path="description" type="text"/>
</p>
<p>
<form:label path="price">Products Price</form:label>
<form:errors path ="price"/>
<form:input path="price" type="text"/>
</p>

<input type="submit" value="Create"/>

</form:form>


</body>
</html>