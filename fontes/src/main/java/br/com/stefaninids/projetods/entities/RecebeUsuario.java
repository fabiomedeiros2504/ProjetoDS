package br.com.stefaninids.projetods.entities;

public class RecebeUsuario {
	String login_adm;
	String password_adm;
	Usuario user;
	
	public String getLogin() {
		return login_adm;
	}
	public void setLogin(String login_adm) {
		this.login_adm = login_adm;
	}
	public String getPassword() {
		return password_adm;
	}
	public void setPassword(String password_adm) {
		this.password_adm = password_adm;
	}
	public Usuario getUsuario() {
		return user;
	}
	public void setUsuario(Usuario usuario) {
		this.user = usuario;
	}
}
