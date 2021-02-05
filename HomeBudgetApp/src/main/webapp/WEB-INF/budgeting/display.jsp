<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>>Budgets Display Page</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class = "container">
	<nav>
		Return to --><a href="/">Login Page</a>	 <!--  |	<a href="/tasks">Welcome Page</a>		-->
	</nav>
<h1>Welcome to ${user.firstName} ${user.lastName}'s Budget Display Page</h1>
<div class = "sign">
<h3>Budgets</h3>				            <a href="/budgeting/assignee/${ttlcrs.id}">Low Sign-Up</a> |  <a href="/budgeting/assignee/${ttlcrs.id}">High Sign-Up</a>
</div>
<table class="table table-dark">
    <thead>
        <tr>
            <th>Budgets:</th>
            <th>Year:</th>
            <th>Month:</th>
            <th>Actions:</th>
        </tr>
 
    </thead>
    <tbody>
        <c:forEach items="${allBudgets}" var="ttlcrs">  <!-- needs to be different names -->        
         <tr>             
         	<td><a href = "/budgeting/show/${ttlcrs.id}">${ttlcrs.budgetName}</a></td>
			<td><c:out value="${ttlcrs.year}"/></td>
            <td><c:out value="${ttlcrs.month}"/></td> 
            <td><c:out value="'Edit' or 'Populated' should show here"/></td>          
        </tr>
        </c:forEach>
    </tbody>
</table>
	
<br><a href="/budgeting/add" class="btn btn-dark">Initiate Budget</a>
</div>
</body>
</html>
