package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utente;
import beans.UtentiDB;

/**
 * This class is used for change password.
 * @author rootLeo00
 */

public class ChangePasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		//PrintWriter out=resp.getWriter();

		//get parameters from request and check for null or empty values
		String username= req.getParameter("username").trim();
		String old_password= req.getParameter("old_password").trim();
		String new_password= req.getParameter("new_password").trim();
		

		//check for null or empty password or username
		if(new_password==null|| new_password.equals("")||old_password==null|| old_password.equals("")||username==null || username.equals("")) {
			//out.print("Please enter both username and password. <br/><br/>");
			req.setAttribute("result", "Please enter both username and password.");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/changePwd.jsp");
			requestDispatcher.forward(req, resp);//Includes the content of a resource (servlet, JSP page, or HTML file) in the response.
		}
		else {
			boolean utentePresente=false;
			UtentiDB utenti = (UtentiDB)this.getServletContext().getAttribute("utentiDB");//DB comune a tutte le servlet
			//check for valid username or old_password
			for(Utente user : utenti.getUtenti()) {
				if(user.getUsername().equals(username))
				{
					
					utentePresente=true;
					if(user.getPassword().equals(old_password)) {
						//Tutto appo
						//Tocca però far sloggare l'utente che ha cambiato password altrimenti non riesce piu ad entrare
						user.setLogged(false);
						user.setPassword(new_password);
						req.setAttribute("result","<strong>Password Updated! </strong> <br>");
						RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/login.jsp");
						requestDispatcher.forward(req, resp);//Includes the content of a resource (servlet, JSP page, or HTML file) in the response.
						
						//resp.sendRedirect(req.getContextPath()+"/pages/login.jsp");
						//A quanto pare forward è da preferire rispetto a sendRedirect perchè 
						//più rapida perchè non usa due http request e inoltre non cambia l'url sul browser

					}else{
						//Password non matcha con quella presente nel db
						req.setAttribute("result","The old password is incorrect! <br>");
						RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/changePwd.jsp");
						requestDispatcher.forward(req, resp);//Includes the content of a resource (servlet, JSP page, or HTML file) in the response.
						
						}
					
				}/*else {
					//Utente non presente e/o sbagliato
					
				}*/
				
			}
			//Utente non presente e/o sbagliato
			if(!utentePresente) {
				req.setAttribute("result","Incorrect or Inexistent user! <br>");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/changePwd.jsp");
				requestDispatcher.forward(req, resp);//Includes the content of a resource (servlet, JSP page, or HTML file) in the response.
					
			}
			
			
		}

	}
}
