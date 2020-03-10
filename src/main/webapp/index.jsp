
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <div class="row pt-3">
        <div class="col-7 w-text">
            <h1>Gregslist</h1>
            <h4>(Not to be confused with Craigslist) Buy, Sell, Trade, or post Job opportunities! Come one come all and browse through your communities amazing ads at prices no one can beat.</h4>
        </div>
        <div class="col-5">
            <div class="card">
                <div class="card-body reg">
                    <h5 class="card-title font-weight-bold">Not a member yet?</h5>
                    <p class="card-text">Don't shop or list your valuable items at those other sketchy adlisters, sign up with Gregslist todayyy!</p>
                    <form action="/register" method="GET">
                        <a href="/register" class="btn btn-primary text-light blk" style="background:#d4372b">Register</a>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <form class="row pt-4" action="/ads" method="GET">
        <a class="red-hover w-text" href="/category?value=0">>> VIEW ALL RECENT ADS</a>
    </form>
    <div class="scrollBx ">
        <c:forEach var="ad" items="${all}">
            <a class="blk" href="/viewAd?adId=${ad.id}" class="dark">
                <div class="cards mr-2">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                    <p>Categories: ${ad.catString}</p>
                    <br>
                    <p>Created by: ${ad.username} on, ${ad.dateMade} </p>
                </div>
            </a>
        </c:forEach>
    </div>

    <form class="row pt-4" action="/category" method="GET">
        <a class="red-hover w-text" href="/category?value=7">>> CARS</a>
    </form>
    <div class="scrollBx">
        <c:forEach var="ad" items="${cars}">
            <a class="blk" href="/viewAd?adId=${ad.id}">
                <div class="cards mr-2">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                    <p>Categories: ${ad.catString}</p>
                    <br>
                    <p>Created by: ${ad.username} on, ${ad.dateMade} </p>
                </div>
            </a>
        </c:forEach>
    </div>

    <form class="row pt-4" action="/category" method="GET">
        <a class="red-hover w-text" href="/category?value=3">>> COMPUTERS</a>
    </form>
    <div class="scrollBx">
        <c:forEach var="ad" items="${computers}">
            <a class="blk" href="/viewAd?adId=${ad.id}">
                <div class="cards mr-2">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                    <p>Categories: ${ad.catString}</p>
                    <br>
                    <p>Created by: ${ad.username} on, ${ad.dateMade} </p>
                </div>
            </a>
        </c:forEach>
    </div>

    <form class="row pt-4" action="/category" method="GET">
        <a class="red-hover w-text" href="/category?value=5">>> JOBS</a>
    </form>
    <div class="scrollBx">
        <c:forEach var="ad" items="${jobs}">
            <a class="blk" href="/viewAd?adId=${ad.id}">
                <div class="cards mr-2">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                    <p>Categories: ${ad.catString}</p>
                    <br>
                    <p>Created by: ${ad.username} on, ${ad.dateMade} </p>
                </div>
            </a>
        </c:forEach>
    </div>

    <form class="row pt-4" action="/category" method="GET">
        <a class="red-hover w-text" href="/category?value=8">>> FURNITURE</a>
    </form>
    <div class="scrollBx">
        <c:forEach var="ad" items="${furniture}">
            <a class="blk" href="/viewAd?adId=${ad.id}">
                <div class="cards mr-2">
                    <h2>${ad.title}</h2>
                    <p>${ad.description}</p>
                    <p>Categories: ${ad.catString}</p>
                    <br>
                    <p>Created by: ${ad.username} on, ${ad.dateMade} </p>
                </div>
            </a>
        </c:forEach>
    </div>

    <%-- ALL OTHER PAGES NEED THIS TAG--%>
    <jsp:include page="WEB-INF/partials/js-script.jsp" />
    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</div>
</body>
</html>
