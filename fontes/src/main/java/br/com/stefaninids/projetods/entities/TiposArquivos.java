package br.com.stefaninids.projetods.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="DS_TB_TIPOS_ARQUIVOS")
@NamedQueries({
	@NamedQuery(name="TiposArquivos.retornaTodosOsTipos", query="SELECT t FROM TiposArquivos t"),
	@NamedQuery(name="TiposArquivos.retornaTiposPorId", query="SELECT t FROM TiposArquivos t " + 
					 "where t.TP_PK.id = :id"),
	@NamedQuery(name="TiposArquivos.retornaTiposPorNome", query="SELECT t FROM TiposArquivos t " + 
			 "where t.nome = :nome")
})
@DynamicUpdate
public class TiposArquivos extends AbstractEntity<TiposArquivosPK> {
	private static final long serialVersionUID = 1L;
	
	@Expose
	@EmbeddedId
	private TiposArquivosPK TP_PK;
	
	@Override
	public TiposArquivosPK getTableId() {
		return TP_PK;
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