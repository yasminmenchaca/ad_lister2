<%--
  Created by IntelliJ IDEA.
  User: johnsantos
  Date: 3/10/2020
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head></head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    Enter file name:<input type="text" name="fileName">
    Select File to Upload:<input type="file" name="picture">
    <br>
    <input type="submit" value="Upload">
</form>
</body>
</html>
