package br.com.stefaninids.projetods.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="DS_TB_NIVEL")
@NamedQueries({
	@NamedQuery(name="Nivel.retornaTodosOsNiveis", query="SELECT n FROM Nivel n"),
	@NamedQuery(name="Nivel.retornaNivelPorId", query="SELECT n FROM Nivel n " + 
					 "where n.NIV_PK.id = :id"),
	@NamedQuery(name="Nivel.retornaNivelPorCodigo", query="SELECT n FROM Nivel n " + 
			 "where n.codigo = :codigo")
})
public class Nivel extends AbstractEntity<NivelPK>{
	private static final long serialVersionUID = 1L;
	
	@Expose
	@EmbeddedId
	private NivelPK NIV_PK;
	
	@Override
	public NivelPK getTableId() {
		return NIV_PK;
	}
	
	@Expose
	@Column(name="descricao", nullable=true, length=20, insertable=true, updatable=true)
	private String descricao;
	
	@Expose
	@Column(name="codigo", nullable=true, length=10, insertable=true, updatable=true)
	private String codigo;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}		
}
