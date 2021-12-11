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

<%
String res="";
if((res=(String)request.getAttribute("result"))==null){
	res="";
}
%>

<p><%=res%></p>

		<!--  QUESTA PAGINA PER ADMIN -->
<form>
	<button name="add" value="list">Visualizza DB</button>
	
</form>

	

	<div>
	<%
	String listUtenti="";
	
	
	
		//prendo il contenuto del database
		//che sicuramente esiste perch� aggiunto almeno nella login e questa parte teoricamente non la vedi prima di effettuare login
			
		if ( request.getParameter("add") != null && request.getParameter("add").equals("list") ){
			UtentiDB utenti=(UtentiDB)this.getServletContext().getAttribute("utentiDB"); 
			listUtenti+="Username\t Gruppo\t Loggato\t Finalized\n";
			for(Utente u: utenti.getUtenti()) {
				listUtenti+=u.getUsername()+"\t"+u.getGruppo()+"\t"+u.isLogged()+"\t"+/*u.isFinalized()+*/"\n";
			}
		}
		
	
	%>
	<textarea id="listaUtenti"  rows="30" cols="55" style="border: 1px solid black;" readonly ><%=listUtenti%></textarea>
	</div>
	
	<!-- <form action="<%//=request.getContextPath()%>/adminServlet" method="post">
	<p>Seleziona l'user a cui forzare la finalizzazione</p>
	<input type=text name=user>
	<input type=submit id=bottone value=cambia>
	</form>
	 -->
	
	<div>
<a href='<%=request.getContextPath()%>/pages/welcome.jsp?'>Vai alla pagina Principale</a>
<br>
</div>

<form action="<%=request.getContextPath()%>/logoutServlet">
<br><button name="logout" value="logoutAdmin">Logout</button>
</form>


</body>
</html>