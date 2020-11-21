<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard for Products & Categories</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h3>Products and Categories</h3>
		<nav>
			<h3><a href="/products/new">Products</a> | <a href="/categories/new">Categories</a></h3>
		</nav>
		<h2>${ products.name }</h2>
		<p>${ products.description }</p>
		<h3>Categories</h3>
		<ul>
		<c:forEach items="${ products.categories }" var="cat">
			<li>${ cat.name }</li>			
		</c:forEach>
		</ul>
		<h3>Add Category</h3>
		<form:form action="/associations/products" method="POST" modelAttribute="association">
			<form:input type="hidden" path="product" value="${ products.id }"/>
			<div class="form-group">
		        <form:label path="category">Song Title</form:label>
		        <form:errors path="category"/>
		        <form:select class="form-control" path="category">
		        <c:forEach items="${ notInCategories }" var="nonCat">
		        	<option value=${ nonCat.id }>${ nonCat.name }</option>
		        </c:forEach>
		        </form:select>
		    </div>
		    <button class="btn btn-primary">Add</button>
		</form:form>
	</div>
</body>
</html> <!-- End of Dashboard -->