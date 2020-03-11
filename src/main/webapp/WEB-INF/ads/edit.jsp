<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="This Add Page" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Please edit your ad!</h1>
    <c:forEach var="ad" items="${single}">
    <div class="col-md-6">
        <form action="/ads/editAd" method="post">
        <h3>${ad.title}</h3>
        <label for="titleInput"><input type="text" name="titleInput" id="titleInput" placeholder="update title"></label>
        <p>${ad.description}</p>
        <label for="descriptionInput"><input type="text" name="descriptionInput" id="descriptionInput" placeholder="update description"></label>
        <button type="submit" class="btn btn-primary">Submit Changes</button>
               <p>Delete ad</p><input type="checkbox" class="form-check-input" id="deleteAd" name="deleteAd" value="true">
            <input type="hidden" name="ad-id" id="ad-id" value="${ad.id}">
        </form>
    </div>
    </c:forEach>





</body>
</html>
