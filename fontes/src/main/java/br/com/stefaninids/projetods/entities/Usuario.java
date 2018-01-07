package br.com.stefaninids.projetods.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="DS_TB_USUARIO")
@NamedQueries({
	@NamedQuery(name="Usuario.retornaUsuario", query="SELECT u FROM Usuario u " + 
			 "where u.login = :login and u.password = :password"),
	@NamedQuery(name="Usuario.retornaUsuarioId", query="SELECT u FROM Usuario u " + 
			 "where u.USR_PK.id = :id")
})
public class Usuario extends AbstractEntity<UsuarioPK>{
	private static final long serialVersionUID = -8637506945533563010L;

	@EmbeddedId
	private UsuarioPK USR_PK;
	
	@Override
	public UsuarioPK getTableId() {
		return USR_PK;
	}
	
	@Expose
	@Column(name="nome", nullable=true, length=100, insertable=true, updatable=true)
	private String nome;
	
	public UsuarioPK getUSR_PK() {
		return USR_PK;
	}

	@Expose
	@Column(name="id_nivel")
    private long nivel;
	
	@Expose
	@Column(name="usr_login", nullable=true, length=50, insertable=true, updatable=true)
	private String login;
	
	@Expose
	@Column(name="usr_password", nullable=true, length=50, insertable=true, updatable=true)
	private String password;
			
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	
	public void setUSR_PK(UsuarioPK uSR_PK) {
		USR_PK = uSR_PK;
	}

	public long getNivel() {
		return nivel;
	}

	public void setNivel(long nivel) {
		this.nivel = nivel;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isAdm(Nivel nivel) {
		if (nivel.getTableId().getId() == this.nivel) {
			return true;
		}
		return false;
	}
}
