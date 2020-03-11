<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Ad Lister" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <header class="container-fluid">
        <div class="row">
            <div class="col-sm-12">
                <h1>Welcome to Ad Lister</h1>
                <h2>Sell, Trade, or Buy</h2>
            </div>
        </div>
    </header>
    <section class="container-fluid">
        <div class="row">
            <div class="col-sm-12 center-block">
                <div class="slideshow-container">

                    <!-- Full-width images with number and caption text -->
                    <div class="mySlides fade">
                        <div class="numbertext"></div>
                        <img src="/Users/johnsantos/adLister/example1/AdLister/src/main/webapp/resources/img/Love_Seat.jpg" style="width:100%">
                        <div class="text"></div>
                    </div>

                    <div class="mySlides fade">
                        <div class="numbertext"></div>
                        <img src="/Users/johnsantos/adLister/example1/AdLister/src/main/webapp/resources/img/66_camaro.jpg" style="width:100%">
                        <div class="text"></div>
                    </div>

                    <div class="mySlides fade">
                        <div class="numbertext"></div>
                        <img src="/img/Love_Seat.jpg" style="width:100%">
                        <div class="text"></div>
                    </div>

                    <!-- Next and previous buttons -->
                    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                    <a class="next" onclick="plusSlides(1)">&#10095;</a>
                </div>
                <br>

                <!-- The dots/circles -->
                <div style="text-align:center">
                    <span class="dot" onclick="currentSlide(1)"></span>
                    <span class="dot" onclick="currentSlide(2)"></span>
                    <span class="dot" onclick="currentSlide(3)"></span>
                </div>
            </div>
        </div>
    </section>

    <jsp:include page="/WEB-INF/partials/scripts.jsp" />
    <script src="js/primary.js"></script>
</body>
</html>
