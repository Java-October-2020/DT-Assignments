<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Budget Build Page</title>
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
<h1>build a budget (crBudget)</h1>

<div class = "hbudget">
<p>Details for Budget: ${budget.budgetName}</p> | <p>Budget ID: ${budget.id}</p> | <p>Year: ${budget.year}</p> | <p>Month: ${budget.month}</p>
</div>

<c:forEach items="${errors}" var="err">
<p>${err}</p>
</c:forEach>

<hr>
<form:form method="POST" action="/budgeting/create" modelAttribute="budget">
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

<button class="btn btn-dark">Build Budget</button>

</form:form>
<br>

<div class="bTable">
<hr>
	<table class="table table-dark">
	<thead>
		<tr>
		<th>ID</th>
		<th>Group</th>
		<th>Transaction</th>
		<th>Projected Cost</th>
		<th>Actual Cost</th>
		<th>Difference</th>
		<th>Category</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${allTrans}" var="trans">
		<tr>
			<td>${trans.id}</td>
			<td>${Groupset.id}</td>
			<td>${trans.transactionName}</td>
			<td>${trans.projectedCost}</td>
			<td>${trans.actualCost}</td>
			<td></td>
			<td>
			</tr>
		</c:forEach>
	</tbody>
	
	</table>
</div>

<hr>
	<div>
		<a href="/categorizing/add" class="btn btn-primary">Add Category</a>
	</div>
	
	<br>
	<div>
		<a href="/grouping/add" class="btn btn-primary">Add Group</a>
	</div>
	
		<br>
	<div>
		<a href="/grouping/create" class="btn btn-primary">Create Group</a>
	</div>
	
		<br>
	<div>
		<a href="/transacting/add" class="btn btn-primary">New Transaction</a>
	</div>
</div>
</body>
</html>
