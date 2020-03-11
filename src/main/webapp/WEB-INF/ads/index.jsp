<%@ page import="java.util.concurrent.TimeUnit" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="${navbar}"/>
<%--<jsp:include page="/WEB-INF/partials/navbar.jsp" />--%>

<div class="container">
    <h1 style="text-align: center">Current Ads</h1>
    <hr>
    <div class="row">
        <c:forEach var="ad" items="${ads}">
            <div class="card col-sm-6 col-md-4 col-lg-3" style="height: 24rem">
                    <%--<img class="card-img-top" src="..." alt="Card image cap">--%>
                <div class="card-body" style="border: 1px solid black">
                    <h4>${ad.category}</h4>
                    <h5 class="card-title text-center center-block">${ad.title}</h5>
                    <p class="card-text text-center center-block">${ad.description}</p>
                    <h5 class="price text-center center-block">Price: $${ad.price}</h5>
                    <img src="${ad.location}" style="width: 50%" class="text-center center-block" alt="test">
                    <a href="/ads/single?ad-id=${ad.id}" class="text-center center-block">View Full Ad</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<jsp:include page="/WEB-INF/partials/scripts.jsp"/>
</body>
</html>
