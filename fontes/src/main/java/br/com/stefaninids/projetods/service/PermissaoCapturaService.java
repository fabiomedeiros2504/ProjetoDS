package br.com.stefaninids.projetods.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import br.com.stefaninids.projetods.dao.service.DAOServiceException;
import br.com.stefaninids.projetods.dao.service.PermissaoCapturaDAO;
import br.com.stefaninids.projetods.dao.service.ServiceException;
import br.com.stefaninids.projetods.entities.MeiosCaptura;
import br.com.stefaninids.projetods.entities.PermissaoCaptura;
import br.com.stefaninids.projetods.entities.PermissaoCapturaPK;
import br.com.stefaninids.projetods.entities.Usuario;
import br.com.stefaninids.projetods.tools.util.log.ProjetoDSLogger;

@Named("br.com.stefaninids.projetods.dao.service.PermissaoCapturaService")
public class PermissaoCapturaService extends AbstractService<PermissaoCapturaDAO, PermissaoCaptura, PermissaoCapturaPK> {
	
	private Logger logger = ProjetoDSLogger.getService();
	
	@Inject
	private PermissaoCapturaDAO permissaoCapturaDAO;
	
	public PermissaoCapturaService() {
		super();
	}
	
	@Override
	protected PermissaoCapturaDAO getGenericDAO() {
		return permissaoCapturaDAO;
	}
	
	public PermissaoCaptura buscaPermissaoPorUsuario(long id_usuario) throws ServiceException {
		try {
			PermissaoCaptura permissao = (PermissaoCaptura) getGenericDAO().buscaPermissaoPorUsuario(id_usuario);
			return permissao;
			
		} catch (DAOServiceException e) {
			logger.log(Level.ERROR, "Erro em UsuarioService.buscaUsuario", e);
		}
		return null;
	}
	
	public void inserirPermissao(Usuario usuario, MeiosCaptura meio) {
		getGenericDAO().inserirPermissao(usuario, meio);
	}		
}
