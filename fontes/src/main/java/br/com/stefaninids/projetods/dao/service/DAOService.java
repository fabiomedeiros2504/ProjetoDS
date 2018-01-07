package br.com.stefaninids.projetods.dao.service;

public interface DAOService<EntityType, PKType> {
	public void salvar(EntityType entityType) throws DAOServiceException;
	public void remover(PKType pkType) throws DAOServiceException;	
	public void detach(EntityType entityType) throws DAOServiceException;
}
