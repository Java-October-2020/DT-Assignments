<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Product Page</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class= "table table-dark" id="container">
<nav>
<a href="/">Home Page</a>
</nav>
<h1><c:out value="${products.name}"/></h1>
<c:out value="${products.description }, $"/>
<c:out value="${products.price}"/>


<h3>Categories:</h3>
<c:if test="${empty categories}">
No Categories have been added
</c:if>
<c:if test="${not empty categories}">
<ul>
<c:forEach var="added" items="${categories}">
<li><c:out value="${added.name}"/></li>
</c:forEach>
</ul>
</c:if>

<hr>

<form action="/products/addCategories/${products.id}" method="post">
<select name="categories">
<c:forEach var="cat" items="${uniqueCats}">
	<option value="${cat.id}">${cat.name}</option>
</c:forEach>
</select>
<button>Add Category</button>
</form>
<hr>



</div>
</body>
</html>