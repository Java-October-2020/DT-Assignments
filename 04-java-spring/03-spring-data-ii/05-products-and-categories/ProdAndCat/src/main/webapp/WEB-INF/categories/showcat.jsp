<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Categories Page</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class= "table table-dark" id="container">
<nav>
<a href="/">Home Page</a>
</nav>
<h1>${categories.name}</h1>
<c:if test = "${empty products}">
No products have been added
</c:if>
<c:if test= "${not empty products}" >
<c:forEach var="added" items="${products }" >
<c:out value="${added.name}"/> <c:out value="${added.description }"/> <c:out value="${added.price}" />
</c:forEach>
</c:if>

<form:form action="/products/addCats/${cate.id }" method="post" modelAttribute="categories">
<br>
<h3>Add Product</h3>
<select name="products">
<c:forEach var="products" items="${unAddedProds}">
<option value="${products.id }">${products.name }</option>

</c:forEach>
</select>
<button>Add Product</button>

</form:form>

</body>
</html>