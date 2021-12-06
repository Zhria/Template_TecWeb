package beans;

import java.time.LocalDateTime;


public class Utente {
	private String email;
    private String username;
    private String password;
    private boolean logged;
    private int tentativi;
    private LocalDateTime ultimaModifica;
    private boolean isAdmin;
    private int gruppo;
    
    public Utente(String email, String username, String password, int gruppo) {
        this.email=email;
    	this.username = username;
        this.password = password;
        this.logged=false;
        this.isAdmin=false;
        this.tentativi=0;
        this.gruppo=gruppo;
        this.ultimaModifica=LocalDateTime.now();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }
    
    public int getTentativi() {
		return tentativi;
	}

	public void setTentativi(int tentativi) {
		this.tentativi = tentativi;
	}

	public LocalDateTime getUltimaModifica() {
		return ultimaModifica;
	}

	public void setUltimaModifica(LocalDateTime ultimaModifica) {
		this.ultimaModifica = ultimaModifica;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getGruppo() {
		return gruppo;
	}

	public void setGruppo(int gruppo) {
		this.gruppo = gruppo;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
