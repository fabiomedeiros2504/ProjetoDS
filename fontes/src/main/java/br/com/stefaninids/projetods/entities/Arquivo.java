package br.com.stefaninids.projetods.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="DS_TB_ARQUIVOS")
@NamedQueries({
	@NamedQuery(name="Arquivo.retornaArquivo", query="SELECT a FROM Arquivo a " + 
			 "where (a.tipo_arquivo.TP_PK.id = :tipoArquivo or :tipoArquivo = 0) and " +
			 "(a.meio_captura.MC_PK.id = :meioCaptura or :meioCaptura = 0) and " +
			 "(a.usuario.USR_PK.id = :idUsuario or :idUsuario = 0) and " + 
			 "a.data_envio >= :dataEnvioInicial and a.data_envio <= :dataEnvioFinal")
})
public class Arquivo extends AbstractEntity<ArquivoPK>{
	private static final long serialVersionUID = 7659694851266901802L;

	@EmbeddedId
	private ArquivoPK ARQ_PK;
	
	@Override
	public ArquivoPK getTableId() {
		return ARQ_PK;
	}
	
	@JoinColumn(name = "id_tipo_arquivo", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private TiposArquivos tipo_arquivo;
	
	@JoinColumn(name = "id_tipo_captura", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private MeiosCaptura meio_captura;
	
	@JoinColumn(name = "id_usuario", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Usuario usuario;
	
	@Column(name="nome", nullable=true, length=200, insertable=true, updatable=true)
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_envio", nullable=false, insertable=true, updatable=true, columnDefinition="DATETIME(3)")
	private Date data_envio;
	
	@Column(name="texto_procurado", nullable=true, length=200, insertable=true, updatable=true)
	private String texto_procurado;
	
	@Column(name="texto_ocorrencias", nullable=true, length=200, insertable=true, updatable=true)
	private long texto_ocorrencias;

	public ArquivoPK getARQ_PK() {
		return ARQ_PK;
	}
	
	public TiposArquivos getTipo_arquivo() {
		return tipo_arquivo;
	}

	public void setTipo_arquivo(TiposArquivos tipo_arquivo) {
		this.tipo_arquivo = tipo_arquivo;
	}

	public MeiosCaptura getMeio_captura() {
		return meio_captura;
	}

	public void setMeio_captura(MeiosCaptura meio_captura) {
		this.meio_captura = meio_captura;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_envio() {
		return data_envio;
	}

	public void setData_envio(Date data_envio) {
		this.data_envio = data_envio;
	}

	public String getTexto_procurado() {
		return texto_procurado;
	}

	public void setTexto_procurado(String texto_procurado) {
		this.texto_procurado = texto_procurado;
	}

	public long getTexto_ocorrencias() {
		return texto_ocorrencias;
	}

	public void setTexto_ocorrencias(long texto_ocorrencias) {
		this.texto_ocorrencias = texto_ocorrencias;
	}
	
	public String retornaPorCodigo(int coluna) {
		String retorno = "";
		
		switch (coluna) {
			case 0:
				retorno = this.nome;
				break;
			case 1:
				retorno = this.tipo_arquivo.getNome();
				break;
			case 2:
				retorno = this.texto_procurado;
				break;
			case 3:
				retorno = Long.toString(this.texto_ocorrencias);
				break;
			case 4:
				retorno = this.usuario.getNome();
				break;
			case 5:
				retorno = this.meio_captura.getNome();
				break;
		}
		
		return retorno;
	}
}
