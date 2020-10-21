<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" type = "text/css" href = "css/style.css">
<title>Current Visit Count</title>
</head>
	<!-- <c:out value="<h1> ${datime} </h1>" escapeXml="false"/> -->
		
	<c:out value="<p class = "vCount"><a href = "/">You have visited X ${count} times</a></p>" escapeXml="false"/>
	 <c:out value="<p class = "retest"><a href = "/">Test another visit?</a></p>" escapeXml="false"/>
	 <a href = "/reset"><button>Reset Session</button></a>
</body>
</html>