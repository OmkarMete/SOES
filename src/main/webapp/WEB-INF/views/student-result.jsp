<%@ taglib prefix="c" uri="jakarta.tags.core" %>
	<!DOCTYPE html>
	<html>

	<head>
		<title>Exam Result - SOES</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/student-result.css">
	</head>

	<body>

		<h1>SOES - Exam Result</h1>

		<h2>${exam.title}</h2>

		<p>Your exam has been submitted successfully.</p>

		<h3>Result</h3>
		<p>Marks Obtained: ${score}</p>
		<p>Total Marks: ${totalMarks}</p>

		<a href="/student/dashboard">Back to Student Dashboard</a>

	</body>

	</html>