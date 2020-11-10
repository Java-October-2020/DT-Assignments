<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New view to render Users</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>

<c:out value="You reached the show.jsp page  & ${languages}"></c:out>

<a class= "dash" href="redirect:/languages/index.jsp"> Dash-board</a>

<c:forEach items="${languages}" var="lang">
	<h1>Name: <c:out value="${lang.name}"></c:out></h1>
	<p>Creator: <c:out value="${lang.creator}"/></p>
	<p>Version: <c:out value="${lang.currentVersion}"/></p>
</c:forEach>
<a href="/languages/edit/${id}">Edit</a>


<form action="/languages/delete/${id}" method="post">
	<input type="hidden" name="_method" value= "delete">
	<input type="submit" value="Delete">
</form>
</body>
</html>