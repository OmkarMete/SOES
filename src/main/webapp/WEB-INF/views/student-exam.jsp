<%@ taglib prefix="c" uri="jakarta.tags.core" %>

	<!DOCTYPE html>
	<html>

	<head>
		<title>Start Exam - SOES</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/student-exam.css">
	</head>

	<body>

		<h1>SOES - Online Examination</h1>

		<h2>${exam.title}</h2>
		<p>${exam.description}</p>
		<p>Duration: ${exam.duration} minutes</p>

		<hr>

		<form action="/student/exams/${exam.id}/submit" method="post">

			<c:forEach var="question" items="${questions}">
				<div>
					<h3>${question.questionText}</h3>

					<label>
						<input type="radio" name="answer_${question.id}" value="A" required>
						A. ${question.optionA}
					</label>
					<br>

					<label>
						<input type="radio" name="answer_${question.id}" value="B">
						B. ${question.optionB}
					</label>
					<br>

					<label>
						<input type="radio" name="answer_${question.id}" value="C">
						C. ${question.optionC}
					</label>
					<br>

					<label>
						<input type="radio" name="answer_${question.id}" value="D">
						D. ${question.optionD}
					</label>
				</div>
				<hr>
			</c:forEach>

			<button type="submit">Submit Exam</button>

		</form>

		<a href="/student/dashboard">Back to Dashboard</a>

	</body>

	</html>