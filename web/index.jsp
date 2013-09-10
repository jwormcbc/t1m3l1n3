<%-- 
    Document   : index
    Created on : 8/07/2013, 11:32:35 AM
    Author     : DellXps15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ups</title>
    </head>
    <body>
     <center>
        <form method="post" action="Uploadersn" enctype="multipart/form-data">
            Seleccion:
            <input type="file" name="uploadFile" />
            <br/><br/>
            <input type="submit" value="Upload" />
        </form>
    </center>
    </body>
</html>
