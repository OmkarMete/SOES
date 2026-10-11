<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>SOES - Login</title>

		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">

		<style>
			* {
				box-sizing: border-box;
				margin: 0;
				padding: 0;
				font-family: Arial, sans-serif;
			}

			body {
				min-height: 100vh;
				display: flex;
				justify-content: center;
				align-items: center;
				padding: 20px;
				background: #eef2f7;
			}

			.login-container {
				width: 420px;
				max-width: 100%;
				padding: 35px;
				background: white;
				border-radius: 16px;
				box-shadow: 0 8px 25px rgba(0, 0, 0, 0.12);
			}

			h1 {
				text-align: center;
				color: #173b70;
				margin-bottom: 8px;
				font-size: 38px;
			}

			.subtitle {
				text-align: center;
				color: #666;
				margin-bottom: 28px;
				font-size: 14px;
			}

			label {
				display: block;
				margin-bottom: 7px;
				color: #333;
				font-weight: bold;
				font-size: 14px;
			}

			input,
			select {
				width: 100%;
				padding: 12px;
				margin-bottom: 18px;
				border: 1px solid #ccd3dd;
				border-radius: 7px;
				outline: none;
				background: #fff;
				font-size: 14px;
			}

			input:focus,
			select:focus {
				border-color: #2457a7;
				box-shadow: 0 0 0 3px rgba(36, 87, 167, 0.10);
			}

			button {
				width: 100%;
				padding: 13px;
				background: linear-gradient(135deg, #2563eb, #173b70);
				color: white;
				border: none;
				border-radius: 7px;
				font-size: 16px;
				font-weight: bold;
				cursor: pointer;
			}

			button:hover {
				background: #173b70;
			}

			.register-link {
				text-align: center;
				margin-top: 20px;
				font-size: 14px;
				color: #666;
			}

			.register-link a {
				color: #2457a7;
				text-decoration: none;
				font-weight: bold;
			}

			.register-link a:hover {
				text-decoration: underline;
			}
		</style>
	</head>

	<body>
		<div class="login-container">
			<h1>SOES</h1>
			<p class="subtitle">Secure Online Examination System</p>

			<form action="${pageContext.request.contextPath}/login" method="post">

				<label for="role">Login As</label>
				<select id="role" name="role" required>
					<option value="">-- Select Your Role --</option>
					<option value="ADMIN">Admin</option>
					<option value="TEACHER">Teacher</option>
					<option value="STUDENT">Student</option>
				</select>

				<label for="email">Email Address</label>
				<input type="email" id="email" name="email" placeholder="Enter your email" required>

				<label for="pass">Password</label>
				<input type="password" id="pass" name="pass" placeholder="Enter your password" required>

				<button type="submit">Login</button>
			</form>

			<p class="register-link">
				Don't have an account?
				<a href="${pageContext.request.contextPath}/register">
					Register here
				</a>
			</p>
		</div>
	</body>
	</html>