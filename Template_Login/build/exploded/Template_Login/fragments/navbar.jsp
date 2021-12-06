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
              
            <div><a href='#[[\$]]#{pageContext.request.contextPath}/login/changePwd.jsp'>Change Password</a></div>
            <div><a href='#[[\$]]#{pageContext.request.contextPath}/login/logout.jsp'>Logout</a></div>
            <div><a href='#[[\$]]#{pageContext.request.contextPath}/login/login.jsp?type=LOG'>Login</a></div>

</div>