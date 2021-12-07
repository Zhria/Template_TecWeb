package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utente;
import beans.UtentiDB;

public class LogoutServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UtentiDB utenti;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		utenti=(UtentiDB)this.getServletContext().getAttribute("utentiDB");
		if(utenti==null) {
			utenti=new UtentiDB();
			this.getServletContext().setAttribute("utentiDB",utenti);
		}
		
		String user=(String)req.getSession().getAttribute("username");
		for(Utente utente: utenti.getUtenti()) {
			if(utente.getUsername().equals(user)) {
				utente.setLogged(false);
				
				resp.sendRedirect(req.getContextPath()+"/pages/login.jsp");
				return;
			}
		}
		//nel caso ci fossero problemi si potrebbe rimandare alla welcome
		//resp.sendRedirect(req.getContextPath()+"/pages/welcome.jsp");
		
	}

}
