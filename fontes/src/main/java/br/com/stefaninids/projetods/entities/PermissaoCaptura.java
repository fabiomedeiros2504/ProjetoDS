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
	@NamedQuery(name="PermissaoCaptura.retornaPermissaoPorUsuario", query="SELECT pc FROM PermissaoCaptura pc " + 
					 "where pc.usuario = :usuario")
})
public class PermissaoCaptura extends AbstractEntity<PermissaoCapturaPK>{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PermissaoCapturaPK PC_PK;
	
	@Override
	public PermissaoCapturaPK getTableId() {
		return PC_PK;
	}
	
	@Column(name="id_tipo_captura")
	private long tipo_captura;
	
	@Column(name="id_usuario")
	private long usuario;

	public long getTipo_captura() {
		return tipo_captura;
	}

	public void setTipo_captura(long tipo_captura) {
		this.tipo_captura = tipo_captura;
	}

	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}	
}
