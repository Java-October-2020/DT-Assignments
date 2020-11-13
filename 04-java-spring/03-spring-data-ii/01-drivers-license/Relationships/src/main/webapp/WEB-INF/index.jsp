<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type = "text/css" href = "css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<title>New Person</title>
</head>
<body>

<h1>New Person</h1>
<br>

  <h1><c:out value="index.jsp:rela id = ${rela.id}"/></h1> 			<!-- print test -->

<form:form action="/new/${rela.id}" method="post" modelAttribute="relationships">
    <p>
        <form:label path="First Name">Name</form:label>
        <form:errors path="First Name"/>
        <form:input path="First Name"/>
    </p>
    <p>
        <form:label path="Last Name">Creator</form:label>
        <form:errors path="Last Nam"/>
        <form:textarea path="Last Nam"/>
    </p>
     
    <input type="submit" value="Create"/>
</form:form>


</body>
</html>