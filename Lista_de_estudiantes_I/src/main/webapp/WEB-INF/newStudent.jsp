<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
<div class="container">
		<h2>New Student</h2>
		<form:form action="/students/new" method="POST" modelAttribute="student">
			<div class="form-group">
				<form:label path="firstName" class="form-label">First Name: </form:label>
				<form:input path="firstName" class="form-control"/>
				<form:errors path="firstName" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="lastName" class="form-label">Last Name: </form:label>
				<form:input path="lastName" class="form-control"/>
				<form:errors path="lastName" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="age" class="form-label">Age: </form:label>
				<form:input path="age" class="form-control"/>
				<form:errors path="age" class="text-danger"/>
			</div>
			<button class="btn btn-success mt-2">Created</button>
		</form:form>
	</div>
</body>
</html>