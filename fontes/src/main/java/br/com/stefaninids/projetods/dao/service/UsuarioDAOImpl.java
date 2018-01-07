package br.com.stefaninids.projetods.dao.service;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.internal.SessionImpl;

import br.com.stefaninids.projetods.entities.Usuario;
import br.com.stefaninids.projetods.entities.UsuarioPK;

@Named("br.com.stefaninids.projetods.dao.service.UsuarioDAOImpl")
public class UsuarioDAOImpl extends DAOServiceImpl<Usuario, UsuarioPK> implements UsuarioDAO {
	@Override
	public Usuario buscaUsuario(String login, String password) throws DAOServiceException {		
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("Usuario.retornaUsuario");
			query.setParameter("login", login);
			query.setParameter("password", password);
			
			query.setMaxResults(1);
			Usuario usuario = (Usuario) query.getSingleResult();
			
			return usuario;
			
		} catch (NoResultException e) {
			return null;
			
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public Usuario buscaUsuarioId(long id) throws DAOServiceException {		
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("Usuario.retornaUsuarioId");
			query.setParameter("id", id);
			
			query.setMaxResults(1);
			Usuario usuario = (Usuario) query.getSingleResult();
			
			return usuario;
			
		} catch (NoResultException e) {
			return null;
			
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
	public void inserirUsuario(Usuario usuario){
		try {
			EntityManager entityManager = getEntityManager();
			SessionImpl sessionImpl = ((SessionImpl) entityManager.getDelegate());
			Connection conn = sessionImpl.connection();	
			
			String getDBUSERByUserIdSql = "{call DS_SP_INSERE_USUARIO(?, ?, ?, ?)}";
			
			CallableStatement callableStatement = null;
			callableStatement = conn.prepareCall(getDBUSERByUserIdSql);
			
			callableStatement.setString(1, usuario.getNome());
			callableStatement.setLong(2, usuario.getNivel());
			callableStatement.setString(3, usuario.getLogin());
			callableStatement.setString(4, usuario.getPassword());
			
			callableStatement.executeUpdate();
			callableStatement.close();
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
}
