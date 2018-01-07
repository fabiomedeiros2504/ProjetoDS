package br.com.stefaninids.projetods.dao.service;

import java.sql.Timestamp;
import java.util.List;

import br.com.stefaninids.projetods.entities.Arquivo;
import br.com.stefaninids.projetods.entities.ArquivoPK;

public interface ArquivoDAO extends DAOService<Arquivo, ArquivoPK> {
	List<Arquivo> buscaArquivos(long meio_captura, long tipo_arquivo, long usuario, Timestamp data_inicial, Timestamp data_final) throws DAOServiceException;
}
