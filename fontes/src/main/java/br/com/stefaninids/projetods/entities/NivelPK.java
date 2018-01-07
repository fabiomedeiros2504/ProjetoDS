package br.com.stefaninids.projetods.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.google.gson.annotations.Expose;

@Embeddable
public class NivelPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Expose
	@Column(name="id", nullable=false, length=11, insertable=true, updatable=true)
	private long id;
	
	public NivelPK() {
		super();
	}
	
	public NivelPK(long id) {
		super();
		this.id = id;
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
