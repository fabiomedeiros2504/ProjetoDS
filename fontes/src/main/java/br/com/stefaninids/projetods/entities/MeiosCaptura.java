package br.com.stefaninids.projetods.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="DS_TB_MEIO_CAPTURA")
@NamedQueries({
	@NamedQuery(name="MeiosCaptura.retornaTodosOsMeios", query="SELECT m FROM MeiosCaptura m"),
	@NamedQuery(name="MeiosCaptura.retornaMeiosPorId", query="SELECT m FROM MeiosCaptura m " + 
					 "where m.MC_PK.id = :id"),
	@NamedQuery(name="MeiosCaptura.retornaMeiosPorNome", query="SELECT m FROM MeiosCaptura m " + 
			 "where m.nome = :nome")
})
public class MeiosCaptura extends AbstractEntity<MeiosCapturaPK>{
	private static final long serialVersionUID = 1L;
	
	@Expose
	@EmbeddedId
	private MeiosCapturaPK MC_PK;
	
	@Override
	public MeiosCapturaPK getTableId() {
		return MC_PK;
	}
	
	@Expose
	@Column(name="nome", nullable=true, length=20, insertable=true, updatable=true)
	private String nome;
			
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}
