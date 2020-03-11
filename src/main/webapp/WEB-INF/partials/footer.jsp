<%--
  Created by IntelliJ IDEA.
  User: johnsantos
  Date: 3/10/20
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<footer class="pt-4 pb-4">
    <ul class="nav nav-pills nav-fill">
        <li id="catBtn" class="nav-item dropdown">
            <a class="nav-link dropdown-toggle red-hover w-text" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Categories</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="${pageContext.request.contextPath}/ads">Recent</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}category?value=1">Cars</a>
<%--                <a class="dropdown-item" href="/category?value=2">Collectibles</a>--%>
<%--                <a class="dropdown-item" href="/category?value=3">Electronics</a>--%>
<%--                <a class="dropdown-item" href="/category?value=4">Furniture</a>--%>
<%--                <a class="dropdown-item" href="/category?value=5">Musical</a>--%>
<%--                <a class="dropdown-item" href="/category?value=6">Outdoor</a>--%>
<%--                <a class="dropdown-item" href="/category?value=7">Sporting</a>--%>
<%--                <a class="dropdown-item" href="/category?value=8">Tools</a>--%>
<%--                <a class="dropdown-item" href="/category?value=9">Toys</a>--%>

                <a class="dropdown-item" href="${pageContext.request.contextPath}category?value=2">Collectibles</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}category?value=3">Electronics</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}category?value=4">Furniture</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}category?value=5">Musical</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}category?value=6">Outdoor</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}category?value=7">Sporting</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}category?value=8">Tools</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}category?value=8">Toys</a>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link red-hover w-text" href="#" onclick="topFunction()" id="myBtn" title="Go to top">Top</a>
        </li>
        <li class="nav-item">
            <a href="#"><i class="fa fa-facebook-official"></i></a>
            <a href="#"><i class="fa fa-google-plus"></i></a>
        </li>
    </ul>
</footer>
