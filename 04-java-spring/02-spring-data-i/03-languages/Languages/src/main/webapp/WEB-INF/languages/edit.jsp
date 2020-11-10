<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Languages Presentation</title>
</head>
<body>
 
<h1>Edit this Language</h1>
<a class= "dLink" href="/delete/${languages.id}">Delete</a> <a href="/">Dashboard</a>
 <!--  <h1><c:out value="edit.jsp:lang id = ${id}"/></h1> 			 print test -->

<form:form action="/edit/${languages.id}" method="POST" modelAttribute="languages">  <!-- don't need id -->
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">Version</form:label>
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
    </p>
   
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>