<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>SOES Admin Dashboard</title>
			<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin-dashboard.css">
		</head>

		<body>
			<h1>SOES Admin Dashboard</h1>

			<div class="summary-cards">

				<div class="summary-card total-card">
					<div class="card-icon">👥</div>
					<h3>Total Users</h3>
					<p>
						<c:out value="${totalUsers}" />
					</p>
				</div>

				<div class="summary-card student-card">
					<div class="card-icon">🎓</div>
					<h3>Students</h3>
					<p>
						<c:out value="${studentCount}" />
					</p>
				</div>

				<div class="summary-card teacher-card">
					<div class="card-icon">👨‍🏫</div>
					<h3>Teachers</h3>
					<p>
						<c:out value="${teacherCount}" />
					</p>
				</div>

				<div class="summary-card admin-card">
					<div class="card-icon">🛡️</div>
					<h3>Admins</h3>
					<p>
						<c:out value="${adminCount}" />
					</p>
				</div>

			</div>

			<h2>Add User</h2>

			<c:if test="${not empty message}">
				<p class="success-message">
					<c:out value="${message}" />
				</p>
			</c:if>

			<c:if test="${not empty error}">
				<p class="error-message">
					<c:out value="${error}" />
				</p>
			</c:if>

			<form action="${pageContext.request.contextPath}/admin/users/add" method="post" class="add-user-form">

				<input type="email" name="email" placeholder="Email address" required>

				<input type="password" name="pass" placeholder="Temporary password" minlength="8" required>

				<select name="role" required>
					<option value="">Select role</option>
					<option value="STUDENT">Student</option>
					<option value="TEACHER">Teacher</option>
				</select>

				<button type="submit">Add User</button>
			</form>

			<h2>Registered Users</h2>

			<table border="1" cellpadding="10">
				<thead>
					<tr>
						<th>ID</th>
						<th>Email</th>
						<th>Role</th>
						<th>Actions</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="user" items="${users}">
						<tr>
							<td>
								<c:out value="${user.id}" />
							</td>

							<td>
								<c:out value="${user.email}" />
							</td>

							<td>
								<c:out value="${user.role}" />
							</td>

							<td>
								<c:if test="${user.role ne 'ADMIN' and user.role ne 'ROLE_ADMIN'}">

									<form action="${pageContext.request.contextPath}/admin/users/${user.id}/role"
										method="post" class="inline-form">

										<select name="role" required>
											<option value="STUDENT" ${user.role eq 'STUDENT' ? 'selected' : '' }>
												Student
											</option>
											<option value="TEACHER" ${user.role eq 'TEACHER' ? 'selected' : '' }>
												Teacher
											</option>
										</select>

										<button type="submit">Update Role</button>
									</form>

									<form action="${pageContext.request.contextPath}/admin/users/${user.id}/delete"
										method="post" class="inline-form"
										onsubmit="return confirm('Are you sure you want to delete this user?');">

										<button type="submit" class="delete-button">
											Delete
										</button>
									</form>

								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<form action="${pageContext.request.contextPath}/admin/dashboard" method="get" class="search-form">

				<input type="text" name="search" placeholder="Search by email..." value="<c:out value='${search}'/>">

				<button type="submit">Search</button>

				<a href="${pageContext.request.contextPath}/admin/dashboard">
					Clear
				</a>
			</form>

			<br>

			<form action="${pageContext.request.contextPath}/logout" method="post">
				<button type="submit">Logout</button>
			</form>

		</body>

		</html>