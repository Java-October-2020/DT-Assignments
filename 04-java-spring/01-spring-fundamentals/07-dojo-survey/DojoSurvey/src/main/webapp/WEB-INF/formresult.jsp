<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index - Form Results</title>
</head>
<body>
<c:set var="fresult" value = "${fresult }"/>
<p>Submitted Info</p>
<br>
<p>Name: <c:out value="${fresult.getName()}"/></p>
<p>Location: </p><c:out value="${fresult.getLocation()}"/>
<p>Language: </p><c:out value="${fresult.getLanguage()}"/>
<p>Comment: </p><c:out value="${fresult.getComment()}"/>
<br>
<a href = "/reset"><button>Go Back</button></a>
</body>
</html>