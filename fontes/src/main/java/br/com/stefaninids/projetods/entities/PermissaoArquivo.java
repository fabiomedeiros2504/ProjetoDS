package br.com.stefaninids.projetods.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="DS_TB_NIVEL")
@NamedQueries({
	@NamedQuery(name="PermissaoArquivo.retornaPermissaoPorUsuario", query="SELECT pa FROM PermissaoArquivo pa " + 
					 "where pa.usuario = :usuario")
})
public class PermissaoArquivo extends AbstractEntity<PermissaoArquivoPK>{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PermissaoArquivoPK PA_PK;
	
	@Override
	public PermissaoArquivoPK getTableId() {
		return PA_PK;
	}
	
	@Column(name="id_tipo_arquivo")
	private long tipo_arquivo;
	
	@Column(name="id_usuario")
	private long usuario;

	public long getTipo_Arquivo() {
		return tipo_arquivo;
	}

	public void setTipo_Arquivo(long tipo_arquivo) {
		this.tipo_arquivo = tipo_arquivo;
	}

	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}
}
