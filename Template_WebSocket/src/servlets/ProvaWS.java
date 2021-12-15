package servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.websocket.*;
import javax.websocket.server.*;

import com.google.gson.Gson;

import beans.OperationReq;
import beans.OperationResp;
import java.util.*;


@ServerEndpoint("/actions")
public class ProvaWS{
	
	private Gson gson;
	
	//private Map counter;
	/*
	 * 
	 * sessione.getBasicRemote().sendText(message);
	 * private static finale Set<ProvaWS_2> calcEndPoints=new CopyOnWriteArraySet<>();
	 * calcEndPoints.add(this);
	 * 
	 */
	@OnOpen
	public void open(Session session) {
		//counter=new HashMap<String,Integer>();
		gson=new Gson();
		
	}
	
	@OnMessage
	public void handleMessage(String message, Session session) {
		//counter++;
		
		
		OperationReq req=gson.fromJson(message, OperationReq.class);
		OperationResp resp=new OperationResp();
		String operando=req.getOperazione();

		try {
			
			/*if(counter>100) {
				resp.setValid(false);
				session.getBasicRemote().sendText(gson.toJson(resp.toString()));
				return;
			}*/
			
		if(operando.equals("+")) {
			double risultato=req.getOp1()+req.getOp2();
			resp.setOp1(req.getOp1());
			resp.setOp2(req.getOp2());
			resp.setRisultato(risultato);
			resp.setSuccess(true);
			resp.setTipoOp(operando);
			resp.setValid(true);
			
			session.getBasicRemote().sendText(gson.toJson(resp));
		}
		if(operando.equals("-")) {
			double risultato=req.getOp1()-req.getOp2();
			resp.setOp1(req.getOp1());
			resp.setOp2(req.getOp2());
			resp.setRisultato(risultato);
			resp.setSuccess(true);
			resp.setTipoOp(operando);
			resp.setValid(true);
			
			session.getBasicRemote().sendText(gson.toJson(resp));
		}
		if(operando.equals("*")) {
			double risultato=req.getOp1()*req.getOp2();
			resp.setOp1(req.getOp1());
			resp.setOp2(req.getOp2());
			resp.setRisultato(risultato);
			resp.setSuccess(true);
			resp.setTipoOp(operando);
			resp.setValid(true);
			
			session.getBasicRemote().sendText(gson.toJson(resp));
		}
		if(operando.equals("/")) {
			
			resp.setOp1(req.getOp1());
			resp.setOp2(req.getOp2());
			resp.setTipoOp(operando);
			
			if(req.getOp2()!=0) {
				double risultato=req.getOp1()/req.getOp2();
				resp.setSuccess(true);
				resp.setValid(true);

				resp.setRisultato(risultato);
				session.getBasicRemote().sendText(gson.toJson(resp));
			}
			else {
				resp.setSuccess(false);
				resp.setValid(false);
				session.getBasicRemote().sendText(gson.toJson(resp));
				}
			
			}
		}
		catch(IOException e) {
			//errorino
			e.printStackTrace();
		}
		
	}

}
