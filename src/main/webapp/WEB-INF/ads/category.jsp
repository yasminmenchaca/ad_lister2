<%--=============================--%>
<%--  http://localhost:8080/ads/create   --%>
<%--=============================--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>





<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
    <title>Category Ads</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="row">
    <div class="col-2 bg-light h-100 pt-4">
        <div class="container">
            <nav class="nav flex-column">
                <a class="nav-link active" href="/category">All</a>
                <a class="nav-link" href="/category?value=1">Cars</a>
                <a class="nav-link" href="/category?value=2">Collectibles</a>
                <a class="nav-link" href="/category?value=3">Electronics</a>
                <a class="nav-link" href="/category?value=4">Furniture</a>
                <a class="nav-link" href="/category?value=5">Musical</a>
                <a class="nav-link" href="/category?value=6">Outdoor</a>
                <a class="nav-link" href="/category?value=7">Sporting</a>
                <a class="nav-link" href="/category?value=8">Tools</a>
                <a class="nav-link" href="/category?value=9">Toys</a>
            </nav>
        </div>
    </div>

    <div class="col-10">
        <div class="container">
            <h1>All the category of Ads</h1>
            <p>Check It Out</p>
            <p>----------------------------------------------------------------------------------</p>
            <c:forEach var="ad" items="${catAd}">

                <a href="/viewAd?adId=${ad.id}">
                    <div style="border: 1px solid grey; display: block; float: left; width: 30%; margin-right: 10px; height: 220px;" class="col-md-4">
                        <h2>${ad.title}</h2>
                        <p>${ad.description}</p>
                        <p>Created On: ${ad.dateMade} by ${ad.username}</p>
                        <p>Categories: ${ad.catString}</p>
                    </div>
                </a>

            </c:forEach>

        </div>
    </div>

</div>
</body>
</html>
