<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create A Group Page</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<nav>
		Return to --><a href="/">Login Page</a> |	<a href="/budgeting">Welcome Page</a>
	</nav>
<div class="container">
<h1>Create A Group (crGroup)s</h1>

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
<form:form method="POST" action="/grouping/create" modelAttribute="groupset">
<div class="form-group">
	<form:label path="groupName">Group Name:
	<form:errors path="groupName"/>
	<form:input path="groupName"/></form:label>
</div>
<div class="form-group">
	<form:label path="description">Description:
	<form:errors path="description"/>
	<form:input path="description"/></form:label>
</div>

<button class="btn btn-dark">Save Group</button>

</form:form>
<br>
	<div>
		<a href="/transacting/add" class="btn btn-primary">Add Transaction</a>
	</div>
	
</div>
</body>
</html>
