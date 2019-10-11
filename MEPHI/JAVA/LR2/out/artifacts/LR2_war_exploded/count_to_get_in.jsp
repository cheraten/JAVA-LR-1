<%--
  Created by IntelliJ IDEA.
  User: cheraten
  Date: 25.09.2019
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>GET IN FORM</title>
</head>

<body>

<h2>Count sum of two numbers</h2>

<p>Your numbers are: ${number1}, ${number2}</p>

<form method="POST">
  <label for="answer">Sum:</label>
  <input id="answer" type="number" name="answer">
  <input type="hidden" name="hash" value=${hash}>
</form>

</body>
</html>