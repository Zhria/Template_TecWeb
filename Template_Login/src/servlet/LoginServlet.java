package servlet;

//import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import beans.LoginJson;
import beans.UtentiDB;

/**
 * This class is used for authentication process.
 * @author rootLeo00
 */

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UtentiDB utenti;
	//private Gson gson;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		//Utilizziamo post quindi leggo dal reader
		//gson=new Gson();
		//Leggo il contenuto del dato in post	
		//LoginJson log=gson.fromJson(req.getReader(), LoginJson.class);
		
		utenti=(UtentiDB)req.getSession().getAttribute("utentiDB");
		if(utenti==null) {
			utenti=new UtentiDB();
			req.getSession().setAttribute("utentiDB",utenti);
		}
		
		String password=req.getParameter("password");
		String username=req.getParameter("username");
		//int tentativi=0;
		//int numMaxTentativi=3;
		
		//se esiste l'id ma la password � sbagliata e non accede allora aumenta i tentativi
		if(utenti.getUsernames().contains(username)) {
			//l'username messo esiste e c'�
			//adesso controllo se la password inserita � quella corretta o meno
			if(utenti.isUtente(username, password)) {
				//Username e password corretti
				if(username.equals("admin") && password.equals("admin")) {
					utenti.findUtente(username, password).setAdmin(true);
				}
				if(!utenti.findUtente(username, password).isLogged()) {
					utenti.findUtente(username, password).setLogged(true);
					resp.sendRedirect(req.getContextPath()+"/pages/welcome.jsp"); //DA MODIFICARE
					/*RequestDispatcher requestDispatcher = req.getRequestDispatcher(req.getContextPath()+"/pages/cart.jsp");
					requestDispatcher.forward(req, resp);*/
				}
				else {
					
				}
				
				
			}
			else {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/login.jsp");
				requestDispatcher.include(req, resp);
				out.print("<p><strong>PASSWORD ERRATA<strong><p/><br/><br/>");
				//tentativi++;
				//if(tentativi>=numMaxTentativi) {
				//	resp.sendRedirect("pages/access_denied.html"); //DA MODIFICARE
				//}
				//else {
				//	utenti.findUtente(username, password).setTentativi(tentativi);
				//}
			}
		}
		else {
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/login.jsp");
			requestDispatcher.include(req, resp);
			out.print("<p><strong>Non esiste questo utente<strong><p/><br/><br/>");
		}
		
		
	}
}
