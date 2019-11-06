<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h3>Registration</h3>
<form action="#" th:action="@{/registration}" th:object="${loginPassword}" method="post">
    <p>Login: <input type="text" th:field="*{login}" /></p>
    <p>Password: <input type="text" th:field="*{password}" /></p>
    <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
</form>
</body>
</html>