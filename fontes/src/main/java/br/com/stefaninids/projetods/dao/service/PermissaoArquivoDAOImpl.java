package br.com.stefaninids.projetods.dao.service;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.internal.SessionImpl;

import br.com.stefaninids.projetods.entities.PermissaoArquivo;
import br.com.stefaninids.projetods.entities.PermissaoArquivoPK;
import br.com.stefaninids.projetods.entities.TiposArquivos;
import br.com.stefaninids.projetods.entities.Usuario;

@Named("br.com.stefaninids.projetods.dao.service.PermissaoArquivoDAOImpl")
public class PermissaoArquivoDAOImpl extends DAOServiceImpl<PermissaoArquivo, PermissaoArquivoPK> implements PermissaoArquivoDAO {
	@Override
	public PermissaoArquivo buscaPermissaoPorUsuario(long id_usuario) throws DAOServiceException {		
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("PermissaoArquivo.retornaPermissaoPorUsuario");
			query.setParameter("usuario", id_usuario);
			
			query.setMaxResults(1);
			PermissaoArquivo permissao = (PermissaoArquivo) query.getSingleResult();
			
			return permissao;
			
		} catch (NoResultException e) {
			return null;
			
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	public void inserirPermissao(Usuario usuario, TiposArquivos tipo){
		try {
			EntityManager entityManager = getEntityManager();
			SessionImpl sessionImpl = ((SessionImpl) entityManager.getDelegate());
			Connection conn = sessionImpl.connection();	
			
			String getDBUSERByUserIdSql = "{call DS_SP_PERMISSAO_ARQUIVOS (?, ?)}";
			
			CallableStatement callableStatement = null;
			callableStatement = conn.prepareCall(getDBUSERByUserIdSql);
			
			callableStatement.setLong(1, tipo.getTableId().getId());
			callableStatement.setLong(2, usuario.getTableId().getId());
			
			callableStatement.executeUpdate();
			callableStatement.close();
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
}
