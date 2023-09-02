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
<title>Students</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container">
		<h2>All Students</h2>
		<p class="float-end text-danger"><c:out value="${error}"></c:out></p>
		<a href="/contact/new" class="float-end m-2">New Contact</a>
		<a href="/students/new" class="float-end m-2">New Student</a>
	
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Age</th>
					<th>Address</th>
					<th>City</th>
					<th>State</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${student}" var="s">
					<tr>
						<td>${s.getId()}</td>
						<td>${s.getFirstName()} ${s.getLastName()}</td>
						<td>${s.getAge()}</td>
						<td>${s.getContact().getAddress()}</td>
						<td>${s.getContact().getCity()}</td>
						<td>${s.getContact().getState()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>