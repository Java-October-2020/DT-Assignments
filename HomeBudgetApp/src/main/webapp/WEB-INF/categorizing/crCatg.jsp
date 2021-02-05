<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create A Category Page</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<nav>
		Return to --><a href="/">Login Page</a> |	<a href="/budgeting">Welcome Page</a>
	</nav>
<div class="container">
<h1>Create A Category</h1>

<div class = >
<h2>Details for Budget: ${budget.budgetName}</h2>
<h2>Budget ID: ${budget.id}</h2>
<h2>Year: ${budget.year}</h2>
<h2>Month: ${budget.month}</h2>
</div>

<c:forEach items="${errors}" var="err">
<p>${err}</p>
</c:forEach>

<hr>
<form:form method="POST" action="/budgeting/create" modelAttribute="budget">
<div class="form-group">
	<form:label path="categoryName">Category Name:
	<form:errors path="categoryName"/>
	<form:input path="categoryName"/></form:label>
</div>

<button class="btn btn-dark">Save Category</button>

</form:form>
<br>
	<div>
		<a href="/grouping/add" class="btn btn-primary">Add Group</a>
	</div>
	
</div>
</body>
</html>
