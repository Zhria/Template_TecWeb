<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ page import="beans.UtentiDB"%>
<%@ page import="beans.Utente"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<!--  QUESTA PAGINA PER ADMIN -->
<form>
	<button name="add" value="list">Visualizza DB</button>
	
</form>

	

	<div>
	<%
	String listUtenti="";
	
	
	
		//prendo il contenuto del database
		//che sicuramente esiste perchè aggiunto almeno nella login e questa parte teoricamente non la vedi prima di effettuare login
			
		if ( request.getParameter("add") != null && request.getParameter("add").equals("list") ){
			UtentiDB utenti=(UtentiDB)this.getServletContext().getAttribute("utentiDB"); 
			listUtenti+="Username \tEmail\tGruppo\t Loggato\n ";
			for(Utente u: utenti.getUtenti()) {
				listUtenti+=u.getUsername()+"\t"+u.getEmail()+"\t"+u.getGruppo()+"\t"+u.isLogged()+"\n";
			}
		}
		
	
	%>
	<textarea id="listaUtenti"  rows="30" cols="55" style="border: 1px solid black;" readonly ><%=listUtenti%></textarea>
	</div>
	
	<div>
<a href='<%=request.getContextPath()%>/pages/welcome.jsp?'>Vai alla pagina Principale</a>
<br>
</div>

<form action="<%=request.getContextPath()%>/logoutServlet">
<br><button name="logout" value="logoutAdmin">Logout</button>
</form>


</body>
</html>