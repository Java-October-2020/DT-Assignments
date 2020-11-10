<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View to render a Language</title>
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	
<!-- ... -->
<a class= "dash" href="/">Dashboard</a>

<h1>Name: <c:out value="${languages.name}"></c:out></h1>
<p>Creator: <c:out value="${languages.creator}"/></p>
<p>Version: <c:out value="${languages.currentVersion}"/></p>

<a href="/edit/${id }">Edit</a>
<!--  <h1><c:out value="showLang:lang id = ${lang.id}"/></h1>
  <h1><c:out value="showLang: id = ${id}"/></h1>  			 print test -->
<form action="/delete/${id}" method="post">
	<input type="hidden" name=" _method" value="delete">
	<input type="submit" value="Delete">
</form>

</body>

</html>