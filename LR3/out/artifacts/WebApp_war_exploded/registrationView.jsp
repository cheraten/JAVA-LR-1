<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

<h3>Registration Page</h3>

<p style="color: red;">${errorRegistrationMessage}</p>

<form method="POST" action="${pageContext.request.contextPath}/registration">
    <table border="0">
        <tr>
            <td>LoginPassword</td>
            <td><input type="text" name="login" value= "${LoginPasswordEntity.login}" /> </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value= "${LoginPasswordEntity.password}" /> </td>
        </tr>

        <tr>
            <td colspan ="2">
                <input type="submit" value= "Submit" />
                <a href="${pageContext.request.contextPath}/">Cancel</a>
            </td>
        </tr>
    </table>
</form>



</body>
</html>