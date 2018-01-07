package br.com.stefaninids.projetods.dao.service;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.stefaninids.projetods.entities.MeiosCaptura;
import br.com.stefaninids.projetods.entities.MeiosCapturaPK;

@Named("br.com.stefaninids.projetods.dao.service.MeioCapturaDAOImpl")
public class MeioCapturaDAOImpl extends DAOServiceImpl<MeiosCaptura, MeiosCapturaPK> implements MeioCapturaDAO {
	@SuppressWarnings("unused")
	private List<Object> list;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MeiosCaptura> buscaMeio() throws DAOServiceException {		
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("MeiosCaptura.retornaTodosOsMeios");
			
			List<MeiosCaptura> meiosCaptura = query.getResultList();
			
			return meiosCaptura;			
		} catch (NoResultException e) {
			return null;			
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public MeiosCaptura buscaMeioId(long id) throws DAOServiceException {		
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("MeiosCaptura.retornaMeiosPorId");
			query.setParameter("id", id);
			
			query.setMaxResults(1);
			MeiosCaptura meiosCaptura = (MeiosCaptura) query.getSingleResult();
			
			return meiosCaptura;
			
		} catch (NoResultException e) {
			return null;
			
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public MeiosCaptura buscaMeioNome(String nome) throws DAOServiceException {		
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("MeiosCaptura.retornaMeiosPorNome");
			query.setParameter("nome", nome);
			
			query.setMaxResults(1);
			MeiosCaptura meiosCaptura = (MeiosCaptura) query.getSingleResult();
			
			return meiosCaptura;
			
		} catch (NoResultException e) {
			return null;
			
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
}
