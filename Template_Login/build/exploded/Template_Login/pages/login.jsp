<!-- pagina per la gestione di errori -->
<%@ page errorPage="../errors/failure.jsp"%>

<!-- accesso alla sessione -->
<%@ page session="true"%>

<!-- codice html restituito al client -->
<!DOCTYPE HTML PUBLIC>
<html>

<head>
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="-1" />
    <title>Login</title>
    <script src="<%=request.getContextPath()%>/scripts/login.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script><!-- libreria jquery -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/styles/default.css" type="text/css" />
</head>
<body>

 <h1>Log in</h1>
        Username: <input type="text" name="username" value=""><br>
        Password: <input type="password" name="password" value=""><br>
       <!--  Email: <input type="email" name="email" value=""><br> -->
        <input type="submit" name="login" value="LOGIN" onclick="callLogin()">
        <form action="/signinservlet" method="post">
       		 <input type="submit" name="signin" value="SIGNIN">
        </form>
        
</body>
</html>