<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Teacher Dashboard - SOES</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/teacher-dashboard.css">
	</head>

	<body>

		<h1>Teacher Dashboard</h1>

		<p>Welcome to the Secure Online Examination System.</p>

		<a href="${pageContext.request.contextPath}/teacher/exams/create">
			Create Exam
		</a>

		<br><br>

		<a href="${pageContext.request.contextPath}/teacher/exams">
			View Exams
		</a>

		<br><br>

		<form action="${pageContext.request.contextPath}/logout" method="post">
			<button type="submit">Logout</button>
		</form>

	</body>

	</html>