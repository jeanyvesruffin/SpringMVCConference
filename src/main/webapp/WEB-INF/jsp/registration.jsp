<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title><spring:message code="registration"/></title>

<style type="text/css">
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>
	<h1>
		<spring:message code="registration"/>
	</h1>
	<form:form modelAttribute="registrationModel">
		<form:errors path="*" cssClass="errorblock" element="div"/>
		<table>
			<tr>
				<td><spring:message code="name"/></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error"/></td>
				
			</tr>
			<tr>
				<spring:message code="save.changes" var="submitText"/>
				<td colspan="3"><input type="submit" value="${submitText}">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>