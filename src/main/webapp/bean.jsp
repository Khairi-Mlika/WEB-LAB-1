<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <jsp:useBean id="p" class="isimm.lab1.bean.Person">
            <jsp:setProperty name="p" property="*"/>
        </jsp:useBean>

        Full Name : <jsp:getProperty name="p" property="firstName"/> <jsp:getProperty name="p" property="lastName"/>
        <br>
        Birthday : <jsp:getProperty name="p" property="birthday"/>
        <br>
        Sexe : <jsp:getProperty name="p" property="sexe"/>
    </body>
</html>
