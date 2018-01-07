package br.com.stefaninids.projetods.dao.service;

import java.util.List;

import br.com.stefaninids.projetods.entities.Nivel;
import br.com.stefaninids.projetods.entities.NivelPK;

public interface NivelDAO extends DAOService<Nivel, NivelPK> {	
	public List<Nivel> buscaNiveis() throws DAOServiceException;	
	public Nivel buscaNivelId(long id) throws DAOServiceException;	
	Nivel buscaNivelCodigo(String codigo) throws DAOServiceException;	
}
