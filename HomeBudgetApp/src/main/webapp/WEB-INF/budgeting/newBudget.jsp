<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>>Budget initiation Page</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<nav>
		Return to --><a href="/">Login Page</a> |	<a href="/budgeting">Welcome Page</a>
	</nav>
<div class="container">
<h1>Initiate a new budget</h1>

<c:forEach items="${errors}" var="err">
<p>${err}</p>
</c:forEach>

<hr>
<form:form method="POST" action="/budgeting/add" modelAttribute="budget">
<div class="form-group">
	<form:label path="budgetName">Budget Name:
	<form:errors path="budgetName"/>
	<form:input path="budgetName"/></form:label>
</div>
<div class="form-group">
	<form:label path="year">Year:
	<form:errors path="year"/>
	<form:input path="year"/></form:label>
</div>
<div class="form-group">
	<form:label path="month">Month:
	<form:errors path="month"/>
	<form:input path="month"/></form:label>
</div>

<button class="btn btn-dark">Create Budget</button>

</form:form>

</div>
</body>
</html>
