package br.com.stefaninids.projetods.service;

import java.io.Serializable;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.stefaninids.projetods.dao.service.DAOService;
import br.com.stefaninids.projetods.dao.service.DAOServiceException;
import br.com.stefaninids.projetods.dao.service.ServiceException;
import br.com.stefaninids.projetods.entities.AbstractEntity;

public abstract class AbstractService<
	GenericDAO extends DAOService<EntityType, PkType>,
	EntityType extends AbstractEntity<PkType>,
	PkType extends Serializable> extends BaseService {
	
	protected abstract GenericDAO getGenericDAO();
	
	public void salvar(EntityType entityType) throws ServiceException {
		try {
			getGenericDAO().salvar(entityType);
		} catch (DAOServiceException e) {
			throw new ServiceException(100, e.getMessage(), e);
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void remover(PkType id) throws ServiceException {
		try {
			getGenericDAO().remover(id);
		} catch (DAOServiceException e) {
			throw new ServiceException(100, e.getMessage(), e);
		}
	}
	
	public void detach(EntityType entityType) throws ServiceException {
		try {
			getGenericDAO().detach(entityType);
		} catch (DAOServiceException e) {
			throw new ServiceException(100, e.getMessage(), e);
		}
	}	
}
