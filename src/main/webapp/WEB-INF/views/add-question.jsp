<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Add Question - SOES</title>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/add-question.css">
		</head>

		<body>

			<h1>Add Question</h1>

			<h3>Exam:
				<c:out value="${exam.title}" />
			</h3>

			<c:if test="${not empty message}">
				<p>
					<c:out value="${message}" />
				</p>
			</c:if>

			<form action="${pageContext.request.contextPath}/teacher/exams/${exam.id}/questions/add" method="post">

				<label>Question</label><br>
				<textarea name="questionText" required></textarea><br><br>

				<label>Option A</label><br>
				<input type="text" name="optionA" required><br><br>

				<label>Option B</label><br>
				<input type="text" name="optionB" required><br><br>

				<label>Option C</label><br>
				<input type="text" name="optionC" required><br><br>

				<label>Option D</label><br>
				<input type="text" name="optionD" required><br><br>

				<label>Correct Answer</label><br>
				<select name="correctAnswer" required>
					<option value="">Select correct option</option>
					<option value="A">Option A</option>
					<option value="B">Option B</option>
					<option value="C">Option C</option>
					<option value="D">Option D</option>
				</select><br><br>

				<label>Marks</label><br>
				<input type="number" name="marks" min="1" required><br><br>

				<button type="submit">Save Question</button>
			</form>

			<br>

			<a href="${pageContext.request.contextPath}/teacher/exams">
				Back to Exams
			</a>

		</body>

		</html>