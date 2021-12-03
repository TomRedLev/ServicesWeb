package common;

import compte.Compte;

public class Client {
	private String name;
	private Compte compte;
	private int token;
	
	
	public Client(String name, Compte compte) {
		super();
		this.name = name;
		this.compte = compte;
	}


	public String getName() {
		return name;
	}

	public Compte getCompte() {
		return compte;
	}


	public int getToken() {
		return token;
	}


	public void setToken(int token) {
		this.token = token;
	}
}