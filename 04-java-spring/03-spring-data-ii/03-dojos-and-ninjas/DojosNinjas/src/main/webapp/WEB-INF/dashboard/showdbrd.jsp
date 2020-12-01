<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard Page</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Dojos And Ninjas</h1>
		<h3><a href="/newDojo">New Dojo</a> | <a href="/newNinja">New Ninja</a></h3>
		<hr/>
		<h2>${dojo.name} Area Ninjas }</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>		
			</thead>
			
			<tbody>
				<c:forEach items="${dojo.ninjas }" var="ninjasList">
					<tr>
						<td>${ninja.firstName } ${ninja.lastName}</td>
						<td>${ninja.age}</td>
					</tr>
				
				</c:forEach>
			</tbody>
		
		</table>
	
	</div>
	

</body>
</html>