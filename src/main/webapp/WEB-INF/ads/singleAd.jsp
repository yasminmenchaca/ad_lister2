<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="This Add Page"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1 style="text-align: center">Viewing Ad</h1>
    <hr>
    <div class="row">
        <c:forEach var="ad" items="${single}">
            <div class="col-md-4 col-md-offset-1 center-block">
                <h2>${ad.title}</h2>
                <p class="description">${ad.description}</p>
                <h5 class="price">Price: $${ad.price}</h5>
            </div>
            <div class="col-md-offset-1 col-md-6 picture-placeholder">

                <img src="${ad.location}" width="400" height="400" alt="test">
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
