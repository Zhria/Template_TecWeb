package it.unibo.tw.servlets;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unibo.tw.beans.LoginJson;
import it.unibo.tw.beans.UtentiDB;

/**
 * This class is used for authentication process.
 * @author rootLeo00
 */

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Gson gson;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		//Utilizziamo post quindi leggo dal reader
		gson=new Gson();
		//Leggo il contenuto del dato in post	
		LoginJson log=gson.fromJson(req.getReader(), LoginJson.class);
		UtentiDB utenti = new UtentiDB();
		
		String password=log.password;
		String username=log.username;
		int tentativi=0;
		int numMaxTentativi=3;
		
		//se esiste l'id ma la password è sbagliata e non accede allora aumenta i tentativi
		if(utenti.getUsernames().contains(username)) {
			//l'username messo esiste e c'è
			//adesso controllo se la password inserita è quella corretta o meno
			if(utenti.isUtente(username, password)) {
				//Username e password corretti
				if(username.equals("admin") && password.equals("admin")) {
					utenti.findUtente(username, password).setAdmin(true);
				}
				utenti.findUtente(username, password).setLogged(true);
				resp.sendRedirect("pages/welcome.jsp"); //DA MODIFICARE
			}
			else {
				out.print("Password Errata!");
				tentativi++;
				if(tentativi>=numMaxTentativi) {
					resp.sendRedirect("pages/access_denied.html"); //DA MODIFICARE
				}
				else {
					utenti.findUtente(username, password).setTentativi(tentativi);
				}
			}
		}
		else {
			out.print("<p><strong>Non esiste questo utente<strong><p/><br/><br/>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/login.jsp");
			requestDispatcher.include(req, resp);
			
		}
		
		
	}
}
