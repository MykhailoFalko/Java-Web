<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Beauty Salon</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<a href="index.jsp" class="btn btn-info" role="button">Back</a>
	<hr>
<div class="container text-center">
	You are logged as ${loggedUser.login}
	<h1>Hi user</h1>
</div>
	<div class="container text-center">
		<div class="row content">
			<div>
				<form class="form-inline" action="controller" method="post">
					<input type="hidden" name="command" value="takeSlot"/>
					<input name="date" type="date" class="form-control">
					<select class="form-select" name="time" >
						<c:forEach items="${listTime}" var="time">
							<option value="${time}"> ${time}</option>
						</c:forEach>
					</select>
					<select class="form-select" name="worker" >
						<c:forEach items="${listSpec}" var="spec">
							<option value="${spec.id}"> ${spec.name}</option>
						</c:forEach>
					</select>
					<select class="form-select" name="service" >
						<c:forEach items="${listProc}" var="proc">
							<option value="${proc.id}"> ${proc.name}</option>
						</c:forEach>
					</select>
					<button class="btn btn-outline-secondary" type="submit">Submit</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>