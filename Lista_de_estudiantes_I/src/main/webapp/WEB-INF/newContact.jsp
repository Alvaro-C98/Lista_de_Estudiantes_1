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
<title>Contcat</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container">
		<h2>Contact Info</h2>
		<form:form action="/contact/new" method="POST" modelAttribute="contact">

			<div class="form-group">
				<form:label path="student" class="form-label">Select student: </form:label>
				<form:select path="student" class="form-control mb-2">
					<c:forEach items="${student}" var="s">
						<form:option value="${s.id}">${s.firstName} ${s.lastName}</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="address" class="form-label">Address: </form:label>
				<form:input path="address" class="form-control"/>
				<form:errors path="address" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="city" class="form-label">City: </form:label>
				<form:input path="city" class="form-control"/>
				<form:errors path="city" class="text-danger"/>
			</div>
			<div class="form-group">
				<form:label path="state" class="form-label">State: </form:label>
				<form:input path="state" class="form-control"/>
				<form:errors path="state" class="text-danger"/>
			</div>
			<button class="btn btn-success mt-2">Created</button>
		</form:form>
	</div>
</body>
</html>