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
 * This class is used for authentication process.
 * @author rootLeo00
 */

public class RegistrazioneServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();

		//get parameters from request and check for null or empty values
		String username= req.getParameter("username").trim();
		String password= req.getParameter("password").trim();

		//check for null or empty password or username
		if(password==null|| password.equals("")||username==null || username.equals("")) {
			out.print("Please enter both username and password. <br/><br/>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/login.jsp");
			requestDispatcher.include(req, resp);//Includes the content of a resource (servlet, JSP page, or HTML file) in the response.
		}
		else {
			//check for not used username
			if(!username.equals("username1")) {
				UtentiDB utenti = new UtentiDB();
				utenti.addUtente(username, password);
				utenti.findUtente(username, password).setLogged(true);		
				resp.sendRedirect("pages/welcome.jsp");//to redirect response to another resource, it may be servlet, jsp or html file.
			}
			else {
				out.print("Already used username! <br/><br/>");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/login.jsp");
				requestDispatcher.include(req, resp);//Includes the content of a resource (servlet, JSP page, or HTML file) in the response.
			}
		}

	}
}
