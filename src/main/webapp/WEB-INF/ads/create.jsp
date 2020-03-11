<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Create a new Ad</h1>
    <form action="/ads/create" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text"></textarea>
        </div>
<%--        cars--%>
<%--        collectibles--%>
<%--        electronics--%>
<%--        furniture--%>
<%--        musical--%>

        <div class="form-check form-check-inline">
            <input class="form-check-input" name="category" type="checkbox" id="cars1" value="cars1">
            <label class="form-check-label" for="cars1">Cars</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" name="category" type="checkbox" id="collectibles2" value="collectibles2">
            <label class="form-check-label" for="collectibles2">Collectibles</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" name="category" type="checkbox" id="electronics3" value="electronics3">
            <label class="form-check-label" for="electronics3">electronics</label>
        </div>
        
        <div class="form-check form-check-inline">
            <input class="form-check-input" name="category" type="checkbox" id="furniture4" value="furniture4">
            <label class="form-check-label" for="furniture4">Furniture</label>
        </div>
        
        <div class="form-check form-check-inline">
            <input class="form-check-input" name="category" type="checkbox" id="musical5" value="musical5">
            <label class="form-check-label" for="musical5">Musical</label>
        </div>
        <%--        outdoor--%>
        <%--        sporting--%>
        <%--        tools--%>
        <%--        toys--%>
        <div class="form-check form-check-inline">
            <input class="form-check-input" name="category" type="checkbox" id="outdoor6" value="outdoor6">
            <label class="form-check-label" for="outdoor6">Outdoor</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" name="category" type="checkbox" id="sporting7" value="sporting7">
            <label class="form-check-label" for="sporting7">Sporting</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" name="category" type="checkbox" id="tools8" value="tools8">
            <label class="form-check-label" for="tools8">Tools</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" name="category" type="checkbox" id="toys9" value="toys9">
            <label class="form-check-label" for="toys9">Toys</label>
        </div>

        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>
