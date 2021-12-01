package it.unibo.tw.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unibo.tw.beans.UtentiDB;

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
			UtentiDB utenti = new UtentiDB();
			boolean okReg=true;
			//check for valid username or old_password
			for(String name : utenti.getUsernames()) {
				if(username.equals(name)) {
					out.print("The username is already used! <br/><br/>");
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/changePwd.jsp");
					requestDispatcher.include(req, resp);//Includes the content of a resource (servlet, JSP page, or HTML file) in the response.
					okReg=false;
				}
			}
			if(okReg) {
				utenti.addUtente(username, new_password);
				utenti.findUtente(username, new_password).setLogged(true);		
				resp.sendRedirect("pages/welcome.jsp");//to redirect response to another resource, it may be servlet, jsp or html file.
			}
			
		}

	}
}
