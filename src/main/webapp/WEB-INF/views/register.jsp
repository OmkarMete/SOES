<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>SOES | Register</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
	</head>

	<body>

		<div class="container">
			<h1>Create Account</h1>
			<p class="subtitle">Register as a student to take examinations</p>

			<form action="${pageContext.request.contextPath}/register" method="post">

				<div class="form-group">
					<label for="email">Email Address</label>
					<input type="email" id="email" name="email" placeholder="Enter your email" required>
				</div>

				<div class="form-group">
					<label for="pass">Password</label>
					<input type="password" id="pass" name="pass" placeholder="Create a password" required>
				</div>

				<button type="submit" class="btn">Create Account</button>
			</form>

			<p class="footer-text">
				Already registered?

				<a href="${pageContext.request.contextPath}/loginpage">
					Login here
				</a>
			</p>

			<p class="brand">SOES &copy; 2026</p>
		</div>

	</body>

	</html>