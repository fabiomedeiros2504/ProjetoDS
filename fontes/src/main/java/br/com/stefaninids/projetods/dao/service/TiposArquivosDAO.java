package br.com.stefaninids.projetods.dao.service;

import java.util.List;

import br.com.stefaninids.projetods.entities.TiposArquivos;
import br.com.stefaninids.projetods.entities.TiposArquivosPK;

public interface TiposArquivosDAO extends DAOService<TiposArquivos, TiposArquivosPK> {	
	public List<TiposArquivos> buscaTipo() throws DAOServiceException;	
	public TiposArquivos buscaTipoId(long id) throws DAOServiceException;	
	public TiposArquivos buscaTipoNome(String nome) throws DAOServiceException;
}
