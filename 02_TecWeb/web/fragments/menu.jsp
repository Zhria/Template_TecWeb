<%@ page import="it.unibo.tw.beans.Utente" %>

<%
	Utente utente= (Utente) request.getSession().getAttribute("utente");
boolean isLoggedIn = false;
if(utente != null )
	if(utente.isLogged())
		isLoggedIn=true;

    //Utente u = ((Utente) session.getAttribute("utente"));
    //boolean isAdmin = u != null && u.getUsername().equals("admin");
%>


<!DOCTYPE html PUBLIC >
<html>
<head>
<title>Menu</title>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/styles/default.css" type="text/css" />
</head>
<body>
	<h3>Indice</h3>

	<ul>
		  <% if (isLoggedIn) { %>
         
            <%// = isAdmin ? "<div><a href='/admin.jsp'>Admin</a></div>" : ""/%>
              
            <li><a href='#[[\$]]#{pageContext.request.contextPath}/login/changePwd.jsp'>Change Password</a></li>
            <li><a href='#[[\$]]#{pageContext.request.contextPath}/login/logout.jsp?type=LOG'>Logout</a></li>
            <li class="nav-username" >Hello: <b><%=((Utente) request.getSession().getAttribute("utente")).getUsername()%></b></li>
        <% } else { %>
            <li><a href='#[[\$]]#{pageContext.request.contextPath}/login/login.jsp?type=LOG'>Login</a></li>
            <li><a href='#[[\$]]#{pageContext.request.contextPath}/login/login.jsp?type=REG'>Registrazione</a></li>
        <% } %>
	</ul>

</body>
</html>
