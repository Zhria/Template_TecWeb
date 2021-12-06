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
<form action="<%=request.getContextPath()%>/loginServlet" method="post">
  
  <div>
           <p>Log in using your username and password!</p>
            <label for="nome">Your username:</label><br>
            <input type="text" id="username" name="username" >

        </div>

        <div>
            <label for="password">Your password:</label><br>
            <input type="password" id="password" name="password">
        </div>
  
    <!--  Email: <input type="email" name="email" value=""><br> -->
    <br><input type="submit" name="login" value="LOGIN">

  </form>
        <form action="<%=request.getContextPath()%>/signinservlet" method="post">
         <div>
         <p>Sign in if you don't have an account yet!</p>
            <label for="username">New Username:</label><br>
            <input type="text" id="username" name="username" >

        </div>

        <div>
            <label for="password">New password:</label><br>
            <input type="password" id="password" name="password">
                <!--  Email: <input type="email" name="email" value=""><br> -->
        </div>
  
       		<br><input type="submit" name="signin" value="SIGNIN">
        </form>
        
</body>
</html>