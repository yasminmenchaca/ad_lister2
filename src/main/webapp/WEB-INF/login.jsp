<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <div class="row">
            <div class="col-xs-offset-4 col-xs-4">
                <h1 style="text-align: center">Please Log In</h1>
                ${username_error}
                ${password_error}
                <form action="/login" method="POST">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input id="username" name="username" class="form-control" type="text">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input id="password" name="password" class="form-control" type="password">
                    </div>
                    <input type="submit" class="btn btn-light" value="Log In">
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="/WEB-INF/partials/scripts.jsp" />
</body>
</html>
