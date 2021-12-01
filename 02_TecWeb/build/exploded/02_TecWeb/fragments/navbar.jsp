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

<style>
    .navbar div {
        margin: 20px;
        flex: 1;
        flex-basis: 150px;
        flex-grow: 0;
    }
    .navbar div.spacer {
        flex-grow: 1;
    }
    .navbar div.nav-username {
        flex: 2;
        flex-basis: 200px;
        flex-grow: 0;
    }
    div.navbar {
        display: flex;
        height: 60px;
        background-color: \#dddddd;
    }
</style>

<div class="navbar">
        <div><a href="#[[\$]]#{pageContext.request.contextPath}/index.jsp">Home</a></div>

    <div class="spacer"></div>
        <% if (isLoggedIn) { %>
         
            <%// = isAdmin ? "<div><a href='/admin.jsp'>Admin</a></div>" : ""/%>
              
            <div><a href='#[[\$]]#{pageContext.request.contextPath}/login/changePwd.jsp'>Change Password</a></div>
            <div><a href='#[[\$]]#{pageContext.request.contextPath}/login/logout.jsp?type=LOG'>Logout</a></div>
            <div class="nav-username" >Hello: <b><%=((Utente) request.getSession().getAttribute("utente")).getUsername()%></b></div>
        <% } else { %>
            <div><a href='#[[\$]]#{pageContext.request.contextPath}/login/login.jsp?type=LOG'>Login</a></div>
            <div><a href='#[[\$]]#{pageContext.request.contextPath}/login/login.jsp?type=REG'>Registrazione</a></div>
        <% } %>
</div>