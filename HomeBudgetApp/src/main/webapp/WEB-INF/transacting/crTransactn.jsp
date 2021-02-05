<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create A Transaction Page</title>
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
<h1>Create A Transaction</h1>

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
<form:form method="POST" action="/transacting/create" modelAttribute="transaction">
<div class="form-group">
	<form:label path="transactionName">Transaction Name:
	<form:errors path="transactionName"/>
	<form:input path="transactionName"/></form:label>
</div>
<div class="form-group">
	<form:label path="effectiveDate">effectiveDate:
	<form:errors path="effectiveDate"/>
	<form:input path="effectiveDate"/></form:label>
</div>
<div class="form-group">
	<form:label path="transactionType">transactionType:
	<form:errors path="transactionType"/>
	<form:input path="transactionType"/></form:label>
</div>
<div class="form-group">
	<form:label path="projectedCost">projectedCost:
	<form:errors path="projectedCost"/>
	<form:input path="projectedCost"/></form:label>
</div>
<div class="form-group">
	<form:label path="actualCost">actualCost:
	<form:errors path="actualCost"/>
	<form:input path="actualCost"/></form:label>
</div>

<button class="btn btn-dark">Save Transaction</button>

</form:form>

	
</div>
</body>
</html>
