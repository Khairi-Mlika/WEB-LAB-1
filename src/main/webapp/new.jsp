<html>
    <header>
        <title>New Page</title>
    </header>
    <body>
        <jsp:useBean id="person" type="lab.mvc.Model.Person" scope="request"/>
        <h1>==== New ===</h1>
        <p>First Name : <jsp:getProperty name="person" property="firstname"/></p>
        <p>Last Name : <jsp:getProperty name="person" property="lastname"/></p>
        <p>Birthday : <jsp:getProperty name="person" property="birthday"/></p>
        <p>Sexe : <jsp:getProperty name="person" property="sexe"/></p>
    </body>
</html>