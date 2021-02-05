<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Budget Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" type = "text/css" href = "css/style.css">
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

<h1>Budget Page Details</h1>
	<div class="card-body">

<div class="container">
<h1>Group for ${budget.budgetName}</h1>
<h2>Owner: <a href="/budget/transaction/${trans.id}">${trans.transactionName} ${trans.transactionAmount}<a/></h2>
<ol>
<c:forEach items="${budget.transaction}" var="btran">
<li>${btran.projectCost} ${btran.actualCost}</li>
</c:forEach>
</ol>
<hr>

	<form:select path="transaction">
	<c:forEach items="${transaction}" var="trans">
	<option value="${trans.id}">${trans.transactionName} ${trans.transactionAmount}</option>	
	</c:forEach>
	</form:select>

	</div>
</body>
</html>
