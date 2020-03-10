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
                <a class="dropdown-item" href="/ads">Recent</a>
                <a class="dropdown-item" href="/category?value=1">Sports</a>
                <a class="dropdown-item" href="/category?value=2">Camping</a>
                <a class="dropdown-item" href="/category?value=3">Computers</a>
                <a class="dropdown-item" href="/category?value=4">Phones</a>
                <a class="dropdown-item" href="/category?value=5">Jobs</a>
                <a class="dropdown-item" href="/category?value=6">Clothing</a>
                <a class="dropdown-item" href="/category?value=7">Cars</a>
                <a class="dropdown-item" href="/category?value=8">Furniture</a>
                <a class="dropdown-item" href="/category?value=9">Other</a>
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
