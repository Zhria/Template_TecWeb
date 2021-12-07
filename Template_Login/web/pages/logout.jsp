<!-- pagina per la gestione di errori -->
<%@ page errorPage="../errors/failure.jsp"%>

<!-- accesso alla sessione -->
<%@ page session="true"%>

<!-- codice html restituito al client -->
<!DOCTYPE HTML PUBLIC >
<html>
<head>
    <title>Logout</title>
   <!-- <script>
        window.onload = () => {
            document.getElementById("form").submit()
        }
    </script>  --> 
</head>
<body>
<!--  NON NECESSARIA PER LA LOGIN FATTA -->
        <form  action="pages/login.html" method="post">
            <input type="button" value="LOGOUT" onclick='alert("Are you sure you want to logout?");'>
        </form>
</body>
</html>