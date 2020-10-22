<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="css/style.css">
<title>Current Visit Count</title>
</head>
	<!-- <c:out value="<h1> ${datime} </h1>" escapeXml="false"/><c:out value="${tformat}" escapeXml="false"/> -->
		
 	<p class="count"><a href="/">You have visited http://http://localhost:8080 </a></p><c:out value=" ${count} " escapeXml="false"/><p class="count"><a href = "/"> times</a></p>
	<p class="retest"><a href="/">Test another visit?</a></p>
	 <a href = "/reset"><button>Reset Session</button></a>
</body>
</html>