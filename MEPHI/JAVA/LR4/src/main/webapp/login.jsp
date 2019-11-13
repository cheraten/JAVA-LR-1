<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<h3>Login Page</h3>

<form:form method="POST" action="login" modelAttribute="loginPassword">
    <tr>
        <form:label path="login">
        <p>login:
            </form:label>
            <form:input path="login"/>
        </p> </tr>
    <tr>
        <form:label path="password">
        <p>password:
            </form:label>
            <form:input path="password"/>
        </p> </tr>
    <input type="submit" name="submit" value="GO!">
</form:form>
<p style="color: #ff0200;">${authError}</p>
<p style="color: #ff0200;">${notContainError}</p>
</div>
</body>
</html>