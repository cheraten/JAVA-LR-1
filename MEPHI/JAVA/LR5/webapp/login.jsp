<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
    <title>Login</title>
    <link rel="shortcut icon" href="https://www.nicepng.com/png/full/33-330168_pixel-png-and-sticker-image-aesthetic-cartoon-icons.png" type="image/png">
</head>
<body>
    <div class="header">
        <div class="menu"><jsp:include page="menu.jsp"></jsp:include></div>
        <div class="head">
            <img src="https://media0.giphy.com/media/QWkuGmMgphvmE/giphy.gif?cid=790b761175097e99fa75c4bcb96e3220528477e8824c5f1c&rid=giphy.gif" height="150">
            <p>Welcome to Login Page</p>
        </div>
    </div>
    <div class="container">
        <form:form method="POST" action="login" modelAttribute="loginPassword">
            <div class="input">
                <input type="text" name="login" placeholder="login">
            </div>
            <div class="input">
                <input type="password" name="password" placeholder="password">
            </div>
            <p style="color: #ff0200;">${authError}</p>
            <p style="color: #0306ff;">${notContainError}</p>
            <input class="submit" type="submit" name="submit" value=" "><br />
        </form:form>
        <img src="http://8bithero.es/assets/images/8bit-pc.gif" height="300">
    </div>
</body>