<%--
  Created by IntelliJ IDEA.
  User: matt
  Date: 8/30/18
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/editAd" method="post">
    <h3>Title</h3>
    <textarea name="title" rows="20" cols="50">${ad.title}</textarea>
    <h3>Description</h3>
    <textarea name="description" rows="20" cols="50">${ad.description}</textarea>
    <p>${ad.dateMade}</p>
    <p>${ad.catString}</p>
    <button name="adId" value="${ad.id}">Submit Changes</button>
</form>

</body>
</html>
