package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utente;
import beans.UtentiDB;

public class AdminServlet  extends HttpServlet {
	
	/**
	 * 
	 * SERVLET MAI UTILIZZATA
	 */
	/*private static final long serialVersionUID = 1L;
	private UtentiDB utenti;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		utenti=(UtentiDB)this.getServletContext().getAttribute("utentiDB");
		if(utenti==null) {
			utenti=new UtentiDB();
			this.getServletContext().setAttribute("utentiDB",utenti);
		}
		
		
		
	}
*/
}