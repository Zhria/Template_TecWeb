package it.unibo.tw.beans;

public class Utente {
    private String username;
    private String password;
    private boolean logged;

    public Utente(String username, String password) {
        this.username = username;
        this.password = password;
        this.logged=false;
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
