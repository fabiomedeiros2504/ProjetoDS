package br.com.stefaninids.projetods.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import br.com.stefaninids.projetods.dao.service.DAOServiceException;
import br.com.stefaninids.projetods.dao.service.ServiceException;
import br.com.stefaninids.projetods.dao.service.UsuarioDAO;
import br.com.stefaninids.projetods.entities.Usuario;
import br.com.stefaninids.projetods.entities.UsuarioPK;
import br.com.stefaninids.projetods.tools.util.log.ProjetoDSLogger;

@Named("br.com.stefaninids.projetods.dao.service.UsuarioService")
public class UsuarioService extends AbstractService<UsuarioDAO, Usuario, UsuarioPK> {
	
	private Logger logger = ProjetoDSLogger.getService();
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	public UsuarioService() {
		super();
	}
	
	@Override
	protected UsuarioDAO getGenericDAO() {
		return usuarioDAO;
	}
	
	public Usuario buscaUsuario(String login, String password) throws ServiceException {
		try {
			Usuario usuario = (Usuario) getGenericDAO().buscaUsuario(login, password);
			return usuario;
			
		} catch (DAOServiceException e) {
			logger.log(Level.ERROR, "Erro em UsuarioService.buscaUsuario", e);
		}
		return null;
	}
	
	public Usuario buscaUsuarioId(long id) throws ServiceException {
		try {
			Usuario usuario = (Usuario) getGenericDAO().buscaUsuarioId(id);
			return usuario;
			
		} catch (DAOServiceException e) {
			logger.log(Level.ERROR, "Erro em UsuarioService.buscaUsuario", e);
		}
		return null;
	}
	
	public void salvar(Usuario usuario) {
		getGenericDAO().inserirUsuario(usuario);
	}		
}
