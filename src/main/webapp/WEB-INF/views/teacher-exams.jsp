<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Teacher Exams - SOES</title>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/teacher-exams.css">
		</head>

		<body>

			<h1>Teacher Exams</h1>

			<a href="${pageContext.request.contextPath}/teacher/exams/create">
				Create New Exam
			</a>

			<br><br>

			<table border="1" cellpadding="10">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Description</th>
						<th>Duration (Minutes)</th>
						<th>Published</th>
						<th>Actions</th>
						<th>Publish</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="exam" items="${exams}">
						<tr>
							<td>
								<c:out value="${exam.id}" />
							</td>
							<td>
								<c:out value="${exam.title}" />
							</td>
							<td>
								<c:out value="${exam.description}" />
							</td>
							<td>
								<c:out value="${exam.duration}" />
							</td>
							<td>
								<c:out value="${exam.published}" />
							</td>

							<td>
								<a href="${pageContext.request.contextPath}/teacher/exams/${exam.id}/questions/add">
									Add Questions
								</a>

								<br><br>

								<a href="${pageContext.request.contextPath}/teacher/exams/${exam.id}/questions">
									View Questions
								</a>
							</td>

							<td>
								<c:choose>
									<c:when test="${exam.published}">
										Published
									</c:when>
									<c:otherwise>
										<form
											action="${pageContext.request.contextPath}/teacher/exams/${exam.id}/publish"
											method="post">
											<button type="submit">Publish Exam</button>
										</form>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<br>

			<a href="${pageContext.request.contextPath}/teacher/dashboard">
				Back to Dashboard
			</a>

		</body>

		</html>