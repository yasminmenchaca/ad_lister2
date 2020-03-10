<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>

</head>
<body>


<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1 class="loginHeading">Please Log In</h1>
    <c:if test="${passwordMatch == false}">
        <p style="color:red">Incorrect Password for this account. Please try again.</p>
    </c:if>
    <c:if test="${accountExists == false}">
        <p style="color:red">Account does not exist. Please try again.</p>
    </c:if>

    <form action="/login" method="POST">
        <div class="loginDiv">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control loginInput" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control loginInput" type="password">
            </div>
            <input type="submit" class="btn btn-block loginBtn" value="Log In">
        </div>
    </form>
</div>
</body>
</html>
