package br.com.stefaninids.projetods.dao.service;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.internal.SessionImpl;

import br.com.stefaninids.projetods.entities.MeiosCaptura;
import br.com.stefaninids.projetods.entities.PermissaoCaptura;
import br.com.stefaninids.projetods.entities.PermissaoCapturaPK;
import br.com.stefaninids.projetods.entities.Usuario;

@Named("br.com.stefaninids.projetods.dao.service.PermissaoCapturaDAOImpl")
public class PermissaoCapturaDAOImpl extends DAOServiceImpl<PermissaoCaptura, PermissaoCapturaPK> implements PermissaoCapturaDAO {
	@Override
	public PermissaoCaptura buscaPermissaoPorUsuario(long id_usuario) throws DAOServiceException {		
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("PermissaoCaptura.retornaPermissaoPorUsuario");
			query.setParameter("usuario", id_usuario);
			
			query.setMaxResults(1);
			PermissaoCaptura permissao = (PermissaoCaptura) query.getSingleResult();
			
			return permissao;
			
		} catch (NoResultException e) {
			return null;
			
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	public void inserirPermissao(Usuario usuario, MeiosCaptura meio){
		try {
			EntityManager entityManager = getEntityManager();
			SessionImpl sessionImpl = ((SessionImpl) entityManager.getDelegate());
			Connection conn = sessionImpl.connection();	
			
			String getDBUSERByUserIdSql = "{call DS_SP_PERMISSAO_TCAPTURA (?, ?)}";
			
			CallableStatement callableStatement = null;
			callableStatement = conn.prepareCall(getDBUSERByUserIdSql);
			
			callableStatement.setLong(1, meio.getTableId().getId());
			callableStatement.setLong(2, usuario.getTableId().getId());
			
			callableStatement.executeUpdate();
			callableStatement.close();
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
}
