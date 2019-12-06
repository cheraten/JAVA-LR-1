<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
    <title>Registration</title>
    <link rel="shortcut icon" href="https://www.nicepng.com/png/full/33-330168_pixel-png-and-sticker-image-aesthetic-cartoon-icons.png" type="image/png">
</head>
<body>
    <div class="header">
        <div class="menu"><jsp:include page="menu.jsp"></jsp:include></div>
        <div class="head">
            <img src=https://i.gifer.com/7rFQ.gif height="150">
            <p>Welcome to Registration Page</p>
        </div>
    </div>

    <div class="container">
        <form:form method="POST" action="registration" modelAttribute="loginPassword">
            <div class="input">
                <input type="text" name="login" placeholder="login">
            </div>
            <div class="input">
                <input type="password" name="password" placeholder="password">
            </div>
            <p style="color: #ff0200;">${regError}</p>
            <p style="color: #0306ff;">${regMessage}</p>
            <input class="submit" type="submit" name="submit" value=" "><br />
        </form:form>
        <img src="https://i.pinimg.com/originals/9d/9b/d1/9d9bd13afce1a798d22ecfd9897730ed.gif" height="300">
    </div>
</body>