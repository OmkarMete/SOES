<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Create Exam - SOES</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/create-exam.css">
	</head>

	<body>

		<h1>Create New Exam</h1>

		<form action="${pageContext.request.contextPath}/teacher/exams/create" method="post">

			<label for="title">Exam Title</label>
			<input type="text" id="title" name="title" required>
			<br><br>

			<label for="description">Description</label>
			<textarea id="description" name="description" required></textarea>
			<br><br>

			<label for="duration">Duration (minutes)</label>
			<input type="number" id="duration" name="duration" min="1" required>
			<br><br>

			<button type="submit">Create Exam</button>

		</form>

		<br>

		<a href="${pageContext.request.contextPath}/teacher/exams">
			View Exams
		</a>

	</body>

	</html>