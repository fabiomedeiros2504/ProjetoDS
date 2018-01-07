package br.com.stefaninids.projetods.dao.service;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.stefaninids.projetods.entities.TiposArquivos;
import br.com.stefaninids.projetods.entities.TiposArquivosPK;

@Named("br.com.stefaninids.projetods.dao.service.TiposArquivosDAOImpl")
public class TiposArquivosDAOImpl extends DAOServiceImpl<TiposArquivos, TiposArquivosPK> implements TiposArquivosDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<TiposArquivos> buscaTipo() throws DAOServiceException {		
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("TiposArquivos.retornaTodosOsTipos");
			
			List<TiposArquivos> tiposArquivos = query.getResultList();
			
			return tiposArquivos;			
		} catch (NoResultException e) {
			return null;			
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public TiposArquivos buscaTipoId(long id) throws DAOServiceException {		
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("TiposArquivos.retornaTiposPorId");
			query.setParameter("id", id);
			
			query.setMaxResults(1);
			TiposArquivos tiposArquivos = (TiposArquivos) query.getSingleResult();
			
			return tiposArquivos;
			
		} catch (NoResultException e) {
			return null;
			
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public TiposArquivos buscaTipoNome(String nome) throws DAOServiceException {		
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("TiposArquivos.retornaTiposPorNome");
			query.setParameter("nome", nome);
			
			query.setMaxResults(1);
			TiposArquivos tiposArquivos = (TiposArquivos) query.getSingleResult();
			
			return tiposArquivos;
			
		} catch (NoResultException e) {
			return null;
			
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}


}
