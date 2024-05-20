<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/style.css">
<title></title>
</head>
<body>
	<nav id="menu">
		<ul>
			<li><a href = "index.jsp">Home</a></li>
			<li><a href = "${pageContext.request.contextPath }/jogadores">Jogadores</a></li>
			<li><a href = "${pageContext.request.contextPath }/times">Times</a></li>
		</ul>
	</nav>
</body>
</html>