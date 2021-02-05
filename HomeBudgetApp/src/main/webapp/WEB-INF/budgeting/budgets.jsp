<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Budget Page</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous"/>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
</head>
<body>
	<div class= "table table-dark" id="container">
	<nav>
		<a href="/">Home Page</a>
	</nav>
	
	<h1> Your Budgets</h1>
		<div class="card">
		  <div class="card-header">
		  	<div class="row">
		  		<div class = "h2 col - 10">
	    		Your Budgets
	    		</div>
	    		<div class="col-2">
	    		 <a href="#">Add Budget</a>
	    		</div>
	    </div>
	  </div>
	  <div class="list-group list-group-flush">
	    <a href="#" class="list-group-item list-group-item-action list-group-item-secondary">Cras justo odio</a>
	    <a href="#" class="list-group-item list-group-item-action list-group-item-secondary">Dapibus ac facilisis in</a>
	    <a href="#" class="list-group-item list-group-item-action list-group-item-secondary">Vestibulum at eros</a>
	  </div>
	</div>
	
</body>
</html>