<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" type = "text/css" href = "css/style.css">
<title>Date Display View</title>
</head>
<body onload = "alert('<c:out value = "This is the ${datime} template"/>')">
	<c:out value="<h1> ${datime} </h1>" escapeXml="false"/>
	 <c:out value="${dformat}"/>
	 <!-- 	<c:out value="${'<b>This is a <c:out> example </b>'}" escapeXml="false"/>
	  -->
</body>
</html>