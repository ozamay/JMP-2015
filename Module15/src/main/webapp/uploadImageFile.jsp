<%--
  Created by IntelliJ IDEA.
  User: Oleksii_Lukash
  Date: 3/21/2016
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <h1>File Upload</h1>

        <form action="logo/upload/images" method="post" enctype="multipart/form-data">

            <p>
                Select a file : <input type="file" name="file" size="45" />
            </p>

            <input type="submit" value="Upload It" />
        </form>
    </body>
</html>
