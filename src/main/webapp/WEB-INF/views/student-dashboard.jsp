<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">

			<title>SOES - Student Dashboard</title>

			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/student-dashboard.css">
		</head>

		<body>

			<div class="dashboard-container">

				<header class="dashboard-header">
					<h1>Welcome to SOES</h1>
					<h2>Student Dashboard</h2>
					<p>You have logged in successfully.</p>
				</header>

				<section class="exam-section">
					<h3>Available Exams</h3>

					<c:if test="${empty exams}">
						<div class="empty-message">
							<p>No published exams are available right now.</p>
						</div>
					</c:if>

					<c:if test="${not empty exams}">
						<div class="table-container">
							<table>
								<thead>
									<tr>
										<th>Exam ID</th>
										<th>Title</th>
										<th>Description</th>
										<th>Duration (minutes)</th>
										<th>Action</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="exam" items="${exams}">
										<tr>
											<td>${exam.id}</td>
											<td>${exam.title}</td>
											<td>${exam.description}</td>
											<td>${exam.duration}</td>
											<td>
												<a class="start-exam-btn"
													href="${pageContext.request.contextPath}/student/exams/${exam.id}">
													Start Exam
												</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:if>
				</section>

				<footer class="dashboard-footer">
					<form action="${pageContext.request.contextPath}/logout" method="post">
						<button type="submit" class="logout-btn">Logout</button>
					</form>
				</footer>

			</div>

		</body>

		</html>