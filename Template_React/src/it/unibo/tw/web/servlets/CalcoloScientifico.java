package it.unibo.tw.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import com.google.gson.Gson;
import it.unibo.tw.web.pojo.ValoriJson;



public class CalcoloScientifico extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Gson gson;

	
	@Override
	public void init() {
		gson = new Gson();	
		
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response)
	throws ServletException, IOException {
		
		ValoriJson myBean = gson.fromJson(request.getReader(), ValoriJson.class);
		//Così prendo il valore del Json ricevuto e lo salvo in una variabile di tipo ValoriJson (che all'interno contiene solamente
		// i due parametri spediti, ovvero l'operazione e il valore
		double resultExpression;
		
		try {
			resultExpression=Double.parseDouble(myBean.espressione);
		}catch(Exception e) {
			resultExpression=1;
			//imposto a 1 perchè se mettessi ad esempio 0 poi mi darebbe problemi con il log e 1/x
		}
		
		String op=myBean.operatore;
		double result=-1;
		
		if(op.equals("log")) {
			result=Math.log(resultExpression);
		}
		if(op.equals("e")) {
			result=Math.exp(resultExpression);
		}
		if(op.equals("1/x")) {
			result=1/resultExpression;
		}
	
		response.getWriter().println(gson.toJson(result));//Restituisco il risultato
		
	}
		
		
}