package br.com.stefaninids.projetods.dao.service;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.stefaninids.projetods.entities.Nivel;
import br.com.stefaninids.projetods.entities.NivelPK;

@Named("br.com.stefaninids.projetods.dao.service.NivelDAOImpl")
public class NivelDAOImpl extends DAOServiceImpl<Nivel, NivelPK> implements NivelDAO {
	@SuppressWarnings("unused")
	private List<Object> list;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Nivel> buscaNiveis() throws DAOServiceException {		
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("Nivel.retornaTodosOsNiveis");
			
			List<Nivel> nivel = query.getResultList();
			
			return nivel;			
		} catch (NoResultException e) {
			return null;			
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public Nivel buscaNivelId(long id) throws DAOServiceException {		
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("Nivel.retornaNivelPorId");
			query.setParameter("id", id);
			
			query.setMaxResults(1);
			Nivel nivel = (Nivel) query.getSingleResult();
			
			return nivel;
			
		} catch (NoResultException e) {
			return null;
			
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public Nivel buscaNivelCodigo(String codigo) throws DAOServiceException {		
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("Nivel.retornaNivelPorCodigo");
			query.setParameter("codigo", codigo);
			
			query.setMaxResults(1);
			Nivel nivel = (Nivel) query.getSingleResult();
			
			return nivel;
			
		} catch (NoResultException e) {
			return null;
			
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
}
