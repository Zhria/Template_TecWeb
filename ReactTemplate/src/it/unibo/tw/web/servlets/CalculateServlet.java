/*CATERINA LEONELLI MATRICOLA 0000915418*/
package it.unibo.tw.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import com.google.gson.Gson;

import it.unibo.tw.web.pojo.Data;

public class CalculateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Gson gson;
	
	@Override
	public void init() {
		gson = new Gson();	
	}
	
	public void service(ServletRequest request, ServletResponse response)
	throws ServletException, IOException {

		  Data data = gson.fromJson(request.getReader(), Data.class);
		    //Così prendo il valore del Json ricevuto e lo salvo in una variabile di tipo ValoriJson (che all'interno contiene solamente
		    // i due parametri spediti, ovvero l'operazione e il valore
		Double res=null;
		
		if(data.getOp().equals("ln")) {
			res= Math.log(data.getX());
		}
		if(data.getOp().equals("sqrt")) {
			res= Math.sqrt(data.getX());
		}
		if(data.getOp().equals("exp")) {
			res= Math.exp(data.getX());
		}
		if(data.getOp().equals("1/x")) {
			res= (1/data.getX());
		}
		
		data.setRes(res);
		
		//fare due oggetti per problemi di security
		
		//return result back to the client
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(gson.toJson(data));

	}

}
