<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head><title>Upload xml file</title>
</head>
<body>
<div class="container" align="center" margin-top="100">
        <form action="/webapp/uploading"  enctype="multipart/form-data" method="post">
            <p>Upload xml file</p>
            <p><input type="file" name="file" accept="text/xml">
            <input type="submit" value="upload"></p>
        </form>

</div>
</body>
</html>