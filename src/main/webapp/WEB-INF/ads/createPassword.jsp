<%--
  Created by IntelliJ IDEA.
  User: johnsantos
  Date: 3/10/2020
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Password</title>
</head>
<body>

    <form action="/createpassword" method="post">
    Password: <input type="text" name="checkPassword"><br>
    <input type="submit" value="Submit">
    </form>
    <br>
    <br>
    ${createdPassword}
</body>
</html>
