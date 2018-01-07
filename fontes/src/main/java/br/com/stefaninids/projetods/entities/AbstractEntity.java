package br.com.stefaninids.projetods.entities;

import java.io.Serializable;

public abstract class AbstractEntity<PkType> extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public AbstractEntity() {
		super();
	}
	
	public abstract PkType getTableId();
	
}
