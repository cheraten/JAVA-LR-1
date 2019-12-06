<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
    <div class="menu">
        <div class="items-column">
            <div class="item">
                <img src="https://sun9-38.userapi.com/c206616/v206616151/1484/ERft-9siwZ8.jpg" height="40">
                <a href="${pageContext.request.contextPath}/registration">
                Sign up
                </a>
            </div>
            <div class="item">
            <img src="https://sun9-31.userapi.com/c206616/v206616151/1495/NEFV44OuSWE.jpg" height="40">
                <a href="${pageContext.request.contextPath}/login">
                Log in
                </a>
            </div>
        </div>
    </div>
</body>