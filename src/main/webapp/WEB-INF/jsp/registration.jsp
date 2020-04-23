<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="registration"></spring:message></title>
</head>
<body>
	<h1><spring:message code="registration"></spring:message></h1>
	<form:form modelAttribute="registrationModel">
		<table>
			<tr>
				<td><spring:message code="name"></spring:message></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
			<spring:message code="save.changes" var="submitText"></spring:message>
				<td colspan="2"><input type="submit" value="${submitText}">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>