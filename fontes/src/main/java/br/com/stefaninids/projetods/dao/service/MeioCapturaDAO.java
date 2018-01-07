package br.com.stefaninids.projetods.dao.service;

import java.util.List;

import br.com.stefaninids.projetods.entities.MeiosCaptura;
import br.com.stefaninids.projetods.entities.MeiosCapturaPK;

public interface MeioCapturaDAO extends DAOService<MeiosCaptura, MeiosCapturaPK> {	
	public List<MeiosCaptura> buscaMeio() throws DAOServiceException;	
	public MeiosCaptura buscaMeioId(long id) throws DAOServiceException;	
	public MeiosCaptura buscaMeioNome(String nome) throws DAOServiceException;
}
