<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Login Page</title>
</head>
<body>
	<center>
		<%
		session.invalidate();
		%>
		<h3>Logged out User: ${pageContext.request.userPrincipal.name} Successfully</h3>
		<h4><a href="${pageContext.request.contextPath}/welcome.html"> Home</a></h4>
	</center>
</body>