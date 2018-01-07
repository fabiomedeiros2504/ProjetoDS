package br.com.stefaninids.projetods.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import br.com.stefaninids.projetods.dao.service.DAOServiceException;
import br.com.stefaninids.projetods.dao.service.ServiceException;
import br.com.stefaninids.projetods.dao.service.TiposArquivosDAO;
import br.com.stefaninids.projetods.entities.TiposArquivos;
import br.com.stefaninids.projetods.entities.TiposArquivosPK;
import br.com.stefaninids.projetods.tools.util.log.ProjetoDSLogger;

@Named("br.com.stefaninids.projetods.dao.service.TipoArquivoService")
public class TipoArquivoService extends AbstractService<TiposArquivosDAO, TiposArquivos, TiposArquivosPK> {
	
	private Logger logger = ProjetoDSLogger.getService();
	
	@Inject
	private TiposArquivosDAO tiposArquivosDAO;
	
	public TipoArquivoService() {
		super();
	}
	
	@Override
	protected TiposArquivosDAO getGenericDAO() {
		return tiposArquivosDAO;
	}
	
	public List<TiposArquivos> buscaTipo() throws ServiceException {
		try {
			List<TiposArquivos> tiposArquivos = (List<TiposArquivos>) getGenericDAO().buscaTipo();
			return tiposArquivos;
			
		} catch (DAOServiceException e) {
			logger.log(Level.ERROR, "Erro em DocumentsService.buscaTipo", e);
		}
		return null;
	}
	
	public TiposArquivos buscaTipoId(long id) throws ServiceException {
		try {
			TiposArquivos tiposArquivos = (TiposArquivos) getGenericDAO().buscaTipoId(id);
			return tiposArquivos;
			
		} catch (DAOServiceException e) {
			logger.log(Level.ERROR, "Erro em DocumentsService.buscaTipoId", e);
		}
		return null;
	}
	
	public TiposArquivos buscaTipoNome(String nome) throws ServiceException {
		try {
			TiposArquivos tiposArquivos = (TiposArquivos) getGenericDAO().buscaTipoNome(nome);
			return tiposArquivos;
			
		} catch (DAOServiceException e) {
			logger.log(Level.ERROR, "Erro em DocumentsService.buscaTipoNome", e);
		}
		return null;
	}
}
