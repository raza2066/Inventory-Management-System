<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" />
<meta name="viewport" content="width=auto, initial-scale=1">
</head>
<body>
	<center>
		<c:if test="${param.error != null}">
									Invalid username and password.
							</c:if>
		<c:if test="${param.logout != null}">
									You have been logged out successfully.
							</c:if>
		<h2>Login with Username and Password</h2>
		<form name='loginForm'
			action="<c:url value='/cstValidateSecureLogin'/>" method='POST'>
			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='msd_uname123'></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='msd_pwd123' /></td>
				</tr>
				<tr>
					<td><center>
							<input name="submit" type="submit" value="Login"
								style="padding: 7px; background-color: #4CAF50" , />
						</center></td>
				</tr>
			</table>
			<%--  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> --%>
		</form>
		<a href="${pageContext.request.contextPath}/welcome.html">Home</a>
	</center>
	<div class="terms1">
		<p align="center" style="font-family: calibri; color: #6666CC;">Copyright
			© 2018 Accenture All Rights Reserved.</p>
	</div>
</body>
</html>