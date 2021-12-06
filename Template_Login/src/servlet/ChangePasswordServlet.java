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
		PrintWriter out=resp.getWriter();

		//get parameters from request and check for null or empty values
		String username= req.getParameter("username").trim();
		String old_password= req.getParameter("old_password").trim();
		String new_password= req.getParameter("new_password").trim();
		

		//check for null or empty password or username
		if(new_password==null|| new_password.equals("")||old_password==null|| old_password.equals("")||username==null || username.equals("")) {
			out.print("Please enter both username and password. <br/><br/>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/changePwd.jsp");
			requestDispatcher.include(req, resp);//Includes the content of a resource (servlet, JSP page, or HTML file) in the response.
		}
		else {
			UtentiDB utenti = (UtentiDB)req.getSession().getAttribute("utentiDB");
			//check for valid username or old_password
			for(Utente user : utenti.getUtenti()) {
				if(user.getUsername().equals(username))
				{
					
					if(user.getPassword().equals(old_password)) {
						user.setPassword(new_password);
						out.print("<strong>Password successfully changed!</strong> <br>");
						RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/login.jsp");
						requestDispatcher.include(req, resp);//Includes the content of a resource (servlet, JSP page, or HTML file) in the response.
						
					}else{
						//Password non matcha con quella presente nel db
						out.print("The old password is incorrect! <br>");
						RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/changePwd.jsp");
						requestDispatcher.include(req, resp);//Includes the content of a resource (servlet, JSP page, or HTML file) in the response.
						
						}
					
				}else {
					//Utente non presente e/o sbagliato
					out.print("Incorrect or Inexistent user! <br>");
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/changePwd.jsp");
					requestDispatcher.include(req, resp);//Includes the content of a resource (servlet, JSP page, or HTML file) in the response.
					
				}
				
			}
			
		}

	}
}
