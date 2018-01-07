package br.com.stefaninids.projetods.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioPK implements Serializable {
	private static final long serialVersionUID = -2637387763659571098L;
	
	@Column(name="id", nullable=false, length=11, insertable=true, updatable=true)
	private long id;
	
	public UsuarioPK() {
		super();
	}
	
	public UsuarioPK(long id) {
		super();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);		
	}
}
