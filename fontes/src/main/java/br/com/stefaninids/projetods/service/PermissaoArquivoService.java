package br.com.stefaninids.projetods.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import br.com.stefaninids.projetods.dao.service.DAOServiceException;
import br.com.stefaninids.projetods.dao.service.PermissaoArquivoDAO;
import br.com.stefaninids.projetods.dao.service.ServiceException;
import br.com.stefaninids.projetods.entities.PermissaoArquivo;
import br.com.stefaninids.projetods.entities.PermissaoArquivoPK;
import br.com.stefaninids.projetods.entities.TiposArquivos;
import br.com.stefaninids.projetods.entities.Usuario;
import br.com.stefaninids.projetods.tools.util.log.ProjetoDSLogger;

@Named("br.com.stefaninids.projetods.dao.service.PermissaoArquivoService")
public class PermissaoArquivoService extends AbstractService<PermissaoArquivoDAO, PermissaoArquivo, PermissaoArquivoPK> {
	
	private Logger logger = ProjetoDSLogger.getService();
	
	@Inject
	private PermissaoArquivoDAO permissaoArquivoDAO;
	
	public PermissaoArquivoService() {
		super();
	}
	
	@Override
	protected PermissaoArquivoDAO getGenericDAO() {
		return permissaoArquivoDAO;
	}
	
	public PermissaoArquivo buscaPermissaoPorUsuario(long id_usuario) throws ServiceException {
		try {
			PermissaoArquivo usuario = (PermissaoArquivo) getGenericDAO().buscaPermissaoPorUsuario(id_usuario);
			return usuario;
			
		} catch (DAOServiceException e) {
			logger.log(Level.ERROR, "Erro em PermissaoArquivoService.buscaPermissaoPorUsuario", e);
		}
		return null;
	}
	
	public void inserirPermissao(Usuario usuario, TiposArquivos tipo) {
		getGenericDAO().inserirPermissao(usuario, tipo);
	}		
}
