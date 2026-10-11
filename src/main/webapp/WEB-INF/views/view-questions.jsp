<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>View Questions - SOES</title>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/view-questions.css">
		</head>

		<body>

			<h1>Questions</h1>

			<h3>Exam:
				<c:out value="${exam.title}" />
			</h3>

			<a href="${pageContext.request.contextPath}/teacher/exams/${exam.id}/questions/add">
				Add Another Question
			</a>

			<br><br>

			<c:if test="${empty questions}">
				<p>No questions added to this exam yet.</p>
			</c:if>

			<c:forEach var="question" items="${questions}">
				<div>
					<hr>

					<h3>
						<c:out value="${question.questionText}" />
					</h3>

					<p>A.
						<c:out value="${question.optionA}" />
					</p>
					<p>B.
						<c:out value="${question.optionB}" />
					</p>
					<p>C.
						<c:out value="${question.optionC}" />
					</p>
					<p>D.
						<c:out value="${question.optionD}" />
					</p>

					<p>
						Correct Answer:
						<c:out value="${question.correctAnswer}" />
					</p>

					<p>
						Marks:
						<c:out value="${question.marks}" />
					</p>
				</div>
			</c:forEach>

			<br>

			<a href="${pageContext.request.contextPath}/teacher/exams">
				Back to Exams
			</a>

		</body>

		</html>