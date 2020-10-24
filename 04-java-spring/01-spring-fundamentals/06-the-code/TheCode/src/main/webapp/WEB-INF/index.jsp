<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Secret Code</title>
</head>
<body>
<h3 id="red">You must train harder!</h3>
<h3>What is the code?</h3>
	<div class="formgroup">
	<form action="/guess" method="post">
			<label for="code"></label>
			<c:out value="${error }"/>
			<input type="text" name="guess" id="code" />
			<button>Try Code</button>
	</form>
	</div>
</body>
</html>