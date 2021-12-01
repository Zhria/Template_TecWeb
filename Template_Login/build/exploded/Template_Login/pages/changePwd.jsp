<!-- pagina per la gestione di errori -->
<%@ page errorPage="../errors/failure.jsp"%>

<!-- accesso alla sessione -->
<%@ page session="true"%>

<!-- codice html restituito al client -->
<!DOCTYPE HTML PUBLIC >
<html>
<head>
    <title><%=pageContext.getServletContext().getInitParameter("titolo")%></title>
</head>
<body>

<div>
    <h2>Cambia la password</h2>
    <form action="changepassword" method="post">
        <label>
            Username:
            <input type="text" name="username"/>
        </label><br/>
        <label>
            Old Password:
            <input type="password" name="old_password"/>
        </label><br/>
        <label>
            New Password:
            <input type="password" name="new_password"/>
        </label><br/>
        <input type="submit" />
    </form>
</div>
</body>
</html>