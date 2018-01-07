package br.com.stefaninids.projetods.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import br.com.stefaninids.projetods.dao.service.DAOServiceException;
import br.com.stefaninids.projetods.dao.service.NivelDAO;
import br.com.stefaninids.projetods.dao.service.ServiceException;
import br.com.stefaninids.projetods.entities.Nivel;
import br.com.stefaninids.projetods.entities.NivelPK;
import br.com.stefaninids.projetods.tools.util.log.ProjetoDSLogger;

@Named("br.com.stefaninids.projetods.dao.service.NivelService")
public class NivelService extends AbstractService<NivelDAO, Nivel, NivelPK> {
	private Logger logger = ProjetoDSLogger.getService();
	
	@Inject
	private NivelDAO nivelDAO;
	
	public NivelService() {
		super();
	}
	
	@Override
	protected NivelDAO getGenericDAO() {
		return nivelDAO;
	}
	
	public Nivel buscaNivelId(long id) throws ServiceException {
		try {
			Nivel nivel = (Nivel) getGenericDAO().buscaNivelId(id);
			return nivel;
			
		} catch (DAOServiceException e) {
			logger.log(Level.ERROR, "Erro em NivelService.buscaNivelId", e);
		}
		return null;
	}
	
	public void salvar(Nivel nivel) {
		nivelDAO.salvar(nivel);
	}

	public Nivel buscaNivelCodigo(String codigo) {
		try {
			Nivel nivel = (Nivel) getGenericDAO().buscaNivelCodigo(codigo);
			return nivel;
			
		} catch (DAOServiceException e) {
			logger.log(Level.ERROR, "Erro em NivelService.buscaNivelCodigo", e);
		}
		return null;
	}
}
