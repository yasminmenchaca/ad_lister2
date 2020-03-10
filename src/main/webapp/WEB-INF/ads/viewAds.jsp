<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="View Ads" />
    </jsp:include>
    <link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="row no-gutters">
    <div class="col-2 h-100 pt-4 sticky-top">
        <div id="sideImg">
            <nav id="side-nav" class="nav flex-column">
                <a class="w-text nav-link active pl-5" href="/category?value=0">All</a>
                <a class="w-text nav-link pl-5" href="/category?value=1"><i class="fa fa-bicycle"></i> Sports</a>
                <a class="w-text nav-link pl-5" href="/category?value=2"><i class="fa fa-tree"></i> Camping</a>
                <a class="w-text nav-link pl-5" href="/category?value=3"><i class="fa fa-laptop"></i> Computers</a>
                <a class="w-text nav-link pl-5" href="/category?value=4"><i class="fa fa-mobile"></i> Phones</a>
                <a class="w-text nav-link pl-5" href="/category?value=5"><i class="fa fa-briefcase"></i> Jobs</a>
                <a class="w-text nav-link pl-5" href="/category?value=6"><i class="fa fa-shopping-bag"></i> Clothing</a>
                <a class="w-text nav-link pl-5" href="/category?value=7"><i class="fa fa-car"></i> Cars</a>
                <a class="w-text nav-link pl-5" href="/category?value=8"><i class="fa fa-bed"></i> Furniture</a>
                <a class="w-text nav-link pl-5" href="/category?value=9">Other</a>
            </nav>
        </div>
    </div>

    <div class="col-10">
        <div class="row">
            <div class="col-md-6">
                <div class="container w-text text-center">
                    <h1>${ad.title}</h1>
                    <p>${ad.description}</p>
                    <p>Posted on ${ad.dateMade}</p>
                    <p>Categories: ${ad.catString}</p>
                    <span>Posted by: </span><a class="red-hover w-text" href="viewOtherProfile?username=${ad.username}">${ad.username}</a>
                    <c:if test="${belongsToUser == true}" >
                        <br>
                        <button><a href="/editAd?adId=${ad.id}">Edit Ad</a></button>
                        <button><a href="/deleteAd?adId=${ad.id}">Delete Ad</a></button>
                    </c:if>
                </div>
            </div>
            <div class="col-md-6 pr-4 pt-4">
                <div class="container">
                    <img src="../../img/adMap.png" width="100%" class="d-inline-block align-top" alt="Map of ad">
                </div>
            </div>

        </div>

        <jsp:include page="/WEB-INF/partials/js-script.jsp" />
        <jsp:include page="/WEB-INF/partials/footer.jsp" />
    </div>
</div>
</body>
</html>
