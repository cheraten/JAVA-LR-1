<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reg</title>
</head>
<body>
<form:form method="POST" action="registration" modelAttribute="loginPassword">
    <form:label path="login">
    <p>login:
    </form:label>
    <form:input path="login"/>
    </p>
    <form:label path="password">
    <p>password:
    </form:label>
    <form:input path="password"/>
    </p>
    <input type="submit" name="submit" value="GO!">
</form:form>
</body>
</html>