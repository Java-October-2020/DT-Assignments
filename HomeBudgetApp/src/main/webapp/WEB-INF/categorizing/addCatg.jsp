<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add A Category Page</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="/budgeting">Budgeting</a></li>
    <li class="breadcrumb-item"><a href="#">Library</a></li>
    <li class="breadcrumb-item active" aria-current="page">"${budget.budgetName}"</li>
  </ol>
</nav>

<nav>
		Return to --><a href="/">Login Page</a> |	<a href="/budgeting">Welcome Page</a>
	</nav>
<div class="container">
<h1>Add A Category</h1>

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
	<form:label path="name">Category Name:
	<form:errors path="name"/>
	<form:input path="name"/></form:label>
</div>
<div class="form-group">
	<form:label path="startDate">startDate:
	<form:errors path="startDate"/>
	<form:input path="startDate"/></form:label>
</div>
<div class="form-group">
	<form:label path="endDate">endDate:
	<form:errors path="endDate"/>
	<form:input path="endDate"/></form:label>
</div>


<button class="btn btn-dark">Add Category</button>

</form:form>
<br>
	<div>
		<a href="/categorizing/create" class="btn btn-primary">Create Category</a>
	</div>
	
	<br>
	<div>
		<a href="/grouping/add" class="btn btn-primary">Add Group</a>
	</div>
</div>
</body>
</html>
