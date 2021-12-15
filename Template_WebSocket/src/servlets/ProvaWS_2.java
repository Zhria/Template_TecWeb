/*package servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.websocket.*;
import javax.websocket.server.*;

import com.google.gson.Gson;

import beans.OperationReq;
import beans.OperationResp;
import beans.UpdateReq;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/actions2")
public class ProvaWS_2 {
	
private Gson gson;
	
	//private Map counter;
	private static final Set<ProvaWS_2> calcEndPoints=new CopyOnWriteArraySet<>();
	private OperationResp operazione=new OperationResp();
	private Session session;
	/*
	 * 
	 * sessione.getBasicRemote().sendText(message);
	 * private static final Set<ProvaWS_2> calcEndPoints=new CopyOnWriteArraySet<>();
	 * calcEndPoints.add(this);
	 * 
	 *
	@OnOpen
	public void open(Session session) {
		//counter=new HashMap<String,Integer>();
		this.session=session;
		gson=new Gson();
		calcEndPoints.add(this);
		
	}
	
	public Session getSession() {
		return session;
	}
	
	@OnMessage
	public void handleMessage(String message, Session session) {
		
		
		UpdateReq up=gson.fromJson(message, UpdateReq.class);
		String operatore=up.getOp();
		double valore=up.getValore();
		if(operatore.equals("op1")) {
		
			operazione.setOp1(valore);
			calcola();
		}
		if(operatore.equals("op2")) {
		
			operazione.setOp2(valore);
			calcola();
		}
		
		for(ProvaWS_2 p: calcEndPoints) {
			
			try {
				if(p.getSession().isOpen()) {
					p.getSession().getBasicRemote().sendText(gson.toJson(operazione));
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	

	private void calcola() {
		
		if(operazione.getTipoOp().equals("+")) {
			double risultato=operazione.getOp1()+operazione.getOp2();
			operazione.setRisultato(risultato);
			operazione.setSuccess(true);
			operazione.setValid(true);
			
		}
		if(operazione.getTipoOp().equals("-")) {
			double risultato=operazione.getOp1()-operazione.getOp2();
			operazione.setRisultato(risultato);
			operazione.setSuccess(true);
			operazione.setValid(true);
			
		}
		
		if(operazione.getTipoOp().equals("*")) {
			double risultato=operazione.getOp1()*operazione.getOp2();
			operazione.setRisultato(risultato);
			operazione.setSuccess(true);
			operazione.setValid(true);
			
		}
		
		if(operazione.getTipoOp().equals("/")) {


			if(operazione.getOp2()!=0) {
				double risultato=operazione.getOp1()/operazione.getOp2();
				operazione.setRisultato(risultato);
				operazione.setSuccess(true);
				operazione.setValid(true);

				operazione.setRisultato(risultato);
			}
			else {
				operazione.setSuccess(false);
				operazione.setValid(false);
				}
		}
		
			

	}
}
*/
package servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.websocket.*;
import javax.websocket.server.*;

import com.google.gson.Gson;

import beans.OperationReq;
import beans.OperationResp;
import beans.UpdateReq;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;





@ServerEndpoint("/actions2")
public class ProvaWS_2 {
	
	private Gson g= new Gson();
	private Session session;
	//private Map<sessionId, count>
	private Map<String, Integer> counterMap;
	private static final Set<ProvaWS_2> arrayServers=new CopyOnWriteArraySet<>();

	
	@OnOpen
	public void open(Session session) {
		counterMap=new HashMap<String, Integer>();
		counterMap.put(session.getId(), 0);
		
		arrayServers.add(this);
		
		this.session=session;
		System.out.println("-------ProvaWS_2 open " +session.getId());
		
	}
	
	public Session getSession() {
		return this.session;
	}
	
	
	@OnClose
	public void close(Session session) {
		this.arrayServers.remove(this);
		System.out.println("-------ProvaWS_2 close: session "+ session.getId());
	}
	
	
	
	 @OnMessage 
	 public void message(Session session, String msg) { 
	
		 
		 System.out.println("-------ProvaWS_2 message " +msg);
		 //ci arriva la sessione!
		int numRichiesteFatte= counterMap.get( session.getId());
		numRichiesteFatte=numRichiesteFatte+1;
		counterMap.put(session.getId(), numRichiesteFatte++);
		
		//System.out.println("______________________________________prova message");
		
		System.out.println(session.getId()+" _____prova message_____   " + numRichiesteFatte);
		
		OperationResp resp=new OperationResp();
//		OperationReq req=new OperationReq();
//		
//		
//		//il sever riceve la updateRequest:
//		UpdateReq upReq ;
//		//tanto la stringa Json dell'oggetto UpdateReq contiene per forza la parola "update"
		if(msg.contains("update")) {
//		upReq =new UpdateReq();
			System.out.println("-------ProvaWS_2 message: contains update! " +msg);
//		//passo a oggetto:
//	//	upReq= g.fromJson(msg, UpdateReq.class);
//		
//		//dobbiamo mandarel'update a tutti!
//		//costruiamo la risposta dell'update!
		
		broadCast(msg); //cos� mandiamo updateRequest in Json al client!
		System.out.println("-------ProvaWS_2 message: contains update! broadcast fatto!");
		
		
		
		
		}else {
			//OPERATION REQUEST!
			System.out.println("Nina: " + session.getId() + " __" + counterMap.get( session.getId()) );
			System.out.println("-------ProvaWS_2 message: NOT contains update! FAccio response!");
			if( counterMap.get( session.getId())>5 ) {
				resp.setValid(false);
			}else {
				resp.setValid(true);
			}
			
			 
			 //prendo il messaggio e lo trasfrmo in oggetto OperationReq
			 OperationReq opr= new OperationReq();
			 
			 opr= g.fromJson(msg, OperationReq.class);
			 
			double op1= opr.getOp1();
			double op2= opr.getOp2();
			String op= opr.getOperazione();
			
			
			resp.setOp1(op1);
			resp.setOp2(op2);
			resp.setTipoOp(op);
			
			
			Double risultato=null;
		if(op.equals("+")) {
			risultato=op1+op2;
		}else if (op.equals("-")) {
			risultato=op1-op2;
		}else if (op.equals("x")) {
			
			risultato=op1*op2;
		}else if (op.equals("/")) {
			risultato=op1/op2;
		}
		
		resp.setRisultato(risultato);
			
			
		broadCast(g.toJson(resp));
			
			
		}
	
		
	 }
	 

//in questo caso json � l'update request!	
private void broadCast(String json) {
	System.out.println("-------ProvaWS_2 broadcast: voglio mandare la stringa "+ json);
	for(ProvaWS_2 serv: arrayServers) {
		System.out.println("-------ProvaWS_2 broadcast: serv ha session "+ serv.getSession().getId());
		try {
			//non voglio mandare update request a me stesso!
			if(!this.getSession().getId().equals(serv.getSession().getId())  ) {
				
				System.out.println("-------ProvaWS_2 broadcast: sono nell'if! ");
				serv.getSession().getBasicRemote().sendText(json);
			}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
}


/*io quando updato con broadcast creo oggetto update request e non request, quindi
 * ci vuole un param per capire se � una update request o una request normale cos� so come 
 * parsare il JSON!*/

} 
