<%--
  Created by IntelliJ IDEA.
  User: Khairi
  Date: 11/7/2026
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.util.*"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Date current_time = new Date();
        var ip = request.getRemoteHost();
    %>
    <%= current_time %>
    <br>
    <%= ip %>
</body>
</html>
