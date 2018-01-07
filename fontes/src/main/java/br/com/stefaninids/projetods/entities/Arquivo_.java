package br.com.stefaninids.projetods.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-07T14:07:19.875-0300")
@StaticMetamodel(Arquivo.class)
public class Arquivo_ {
	public static volatile SingularAttribute<Arquivo, ArquivoPK> ARQ_PK;
	public static volatile SingularAttribute<Arquivo, TiposArquivos> tipo_arquivo;
	public static volatile SingularAttribute<Arquivo, String> nome;
	public static volatile SingularAttribute<Arquivo, Date> data_envio;
	public static volatile SingularAttribute<Arquivo, String> texto_procurado;
	public static volatile SingularAttribute<Arquivo, Long> texto_ocorrencias;
	public static volatile SingularAttribute<Arquivo, MeiosCaptura> meio_captura;
	public static volatile SingularAttribute<Arquivo, Usuario> usuario;
}
