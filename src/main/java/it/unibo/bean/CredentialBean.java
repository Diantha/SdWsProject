package it.unibo.bean;

public class CredentialBean {
	private int idCredenziale;
	private String username;
	private String password;
	private int idUtente;
	
	public CredentialBean() {
		
	}
	
	public int getIdCredenziale() {
		return idCredenziale;
	}
	public void setIdCredenziale(int idCredenziale) {
		this.idCredenziale = idCredenziale;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	
}
