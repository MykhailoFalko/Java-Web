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
<h1>Hi admin</h1>
</div>

<div>
    <table class="table table-sm">
        <thead>
        <tr>
            <td scope="col">
                ID
            </td>
            <td scope="col">
                Date
            </td>
            <td scope="col">
                Time
            </td>
            <td scope="col">
                ServiceId
            </td>
            <td scope="col">
                ClientId
            </td>
            <td scope="col">
                WorkerId
            </td>
            <td scope="col">
                Status
            </td>
        </tr>
        </thead>
        <c:forEach items="${listSlot}" var="slot">
            <tr>
                <td>${slot.id}</td>
                <td>${slot.date}</td>
                <td>${slot.time}</td>
                <td>${slot.serviceId}</td>
                <td>${slot.clientId}</td>
                <td>${slot.workerId}</td>
                <td><c:if test="${slot.isDone==0}">
                    Not Done
                    </c:if>
                    <c:if test="${slot.isDone==1}">
                        Done
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>