<!-- pagina per la gestione di errori -->
<%@ page errorPage="../errors/failure.jsp"%>

<!-- accesso alla sessione -->
<%@ page session="true"%>

<!--  -->
<%
    String tipo = request.getParameter("type");
    boolean isReg = true;
    if(tipo!=null)
    if (tipo.equals("LOG"))
        isReg = false;
    
%>
<!-- codice html restituito al client -->
<!DOCTYPE HTML PUBLIC>
<html>

<head>
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="-1" />
    <title>Login</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script><!-- libreria jquery -->
    <link rel="stylesheet" href="../styles/default.css" type="text/css" />
</head>
<body>

<%
    if (isReg){
       
       
       %>
       <h1>Nuova registrazione</h1>
         <form id="login" action="registrazioneservlet" method="post">
        Username: <input type="text" name="username" value=""><br>
        Password: <input type="password" name="password" value=""><br>
        <input type="submit" name="submit" value="login">
    </form>
       <%
    }else{
%>
 <h1>Log in utente</h1>
    <form id="login" action="loginservlet" method="post">
        Username: <input type="text" name="username" value=""><br>
        Password: <input type="password" name="password" value=""><br>
        <input type="submit" name="submit" value="login">
    </form>
       <%
    }
%>
</body>
</html>