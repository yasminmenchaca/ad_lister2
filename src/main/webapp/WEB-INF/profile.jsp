<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar_logout.jsp"/>


<h1 style="text-align: center">Welcome, ${sessionScope.user.username}!</h1>
<div>
    <button id="edit-profile" class="center-block">Edit Profile</button>
</div>
<hr>
<form id="edit-form" action="/profile" method="post" class="hidden center-block text-center">
    <h3>Email: ${sessionScope.user.email}</h3>
    <label for="emailInput"><input type="text" name="emailInput" id="emailInput" placeholder="update email"></label>
    <h3>Update Password</h3>
    <label for="passwordInput"><input type="text" name="passwordInput" id="passwordInput" placeholder="update password"></label><br>

    <button id="edit-changes" type="submit" class="btn btn-primary">Edit</button>
</form>

<div class="container">
    <div class="row">
        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>
                <img src="${ad.location}" style="width: 40%;" alt="test">
                <h2>${message}</h2>
                <a href="/ads/editAd?ad-id=${ad.id}">Edit this ad.</a>
            </div>
        </c:forEach>
    </div>
</div>

<jsp:include page="/WEB-INF/partials/scripts.jsp"/>
<script src="/js/profile.js"></script>

</body>
</html>