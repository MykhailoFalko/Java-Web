<html>
<head>
	<title>Beauty Salon</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/login.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
	<div class="sidenav">
		<div class="login-main-text">
			<h2>Beauty Salon<br> Login Page</h2>
			<p>Login or register from here to access.</p>
		</div>
	</div>
	<div class="main">
		<div class="col-md-6 col-sm-12">
			<div class="login-form">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="login" />
					<div class="form-group">
						<label>User Name</label>
						<input name="login" class="form-control" placeholder="User Name">
					</div>
					<div class="form-group">
						<label>Password</label>
						<input type="password" name="password"class="form-control" placeholder="Password">
					</div>
					<button type="submit" class="btn btn-black">Login</button>
				</form>
				<form action="register.jsp">
					<button class="btn btn-secondary" >Register</button>
				</form>

			</div>
		</div>
	</div>
</body>
</html>