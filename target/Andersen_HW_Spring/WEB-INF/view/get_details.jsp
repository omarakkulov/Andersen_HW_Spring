<%--
  Created by IntelliJ IDEA.
  User: akk
  Date: 13.05.2021
  Time: 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Details</title>
</head>
<body>
<h2>Уважаемый пользователь, введите ваше имя</h2>
<br>
<form action="showDetails" method="get">
    <label>
        <input type="text"
               name="employeeName"
               placeholder="Введите ваше имя">
    </label>
    <input type="submit" value="Подтвердить">
</form>
</body>
</html>
