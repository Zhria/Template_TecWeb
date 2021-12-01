package it.unibo.tw.beans;

import java.util.ArrayList;
import java.util.List;


public class UtentiDB {
	private List<Utente> utenti;
	
    public UtentiDB() {
    	this.utenti =new ArrayList<Utente>();
    	Utente u = new Utente("username1","password1");
    	this.utenti.add(u);
    	u=new Utente("admin","admin");
    	this.utenti.add(u);
    	u=new Utente("u2","p2");
    	this.utenti.add(u);
    }
	public List<Utente> getUtenti() {
		return utenti;
	}
	
	public void addUtente(String username, String password) {
		this.utenti.add(new Utente(username, password));
	}
	
	public Utente findUtente(String username, String password) {
		for(Utente u : getUtenti()) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}
	
	public boolean isUtente(String username, String password) {
		boolean res=false;
		if(this.findUtente(username, password)!=null) res=false;
		else res=true;
		return res;
	}
	
	public List<String> getUsernames(){
		List<String> res=new ArrayList<String>();
		for(Utente u:this.getUtenti()) {
			res.add(u.getUsername());
		}
		return res;
		
	}

}
