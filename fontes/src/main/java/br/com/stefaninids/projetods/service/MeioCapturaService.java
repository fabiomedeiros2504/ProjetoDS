package br.com.stefaninids.projetods.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import br.com.stefaninids.projetods.dao.service.DAOServiceException;
import br.com.stefaninids.projetods.dao.service.MeioCapturaDAO;
import br.com.stefaninids.projetods.dao.service.ServiceException;
import br.com.stefaninids.projetods.entities.MeiosCaptura;
import br.com.stefaninids.projetods.entities.MeiosCapturaPK;
import br.com.stefaninids.projetods.tools.util.log.ProjetoDSLogger;

@Named("br.com.stefaninids.projetods.dao.service.MeioCapturaService")
public class MeioCapturaService extends AbstractService<MeioCapturaDAO, MeiosCaptura, MeiosCapturaPK> {
	
	private Logger logger = ProjetoDSLogger.getService();
	
	@Inject
	private MeioCapturaDAO meioCapturaDAO;
	
	public MeioCapturaService() {
		super();
	}
	
	@Override
	protected MeioCapturaDAO getGenericDAO() {
		return meioCapturaDAO;
	}
	
	public List<MeiosCaptura> buscaMeio() throws ServiceException {
		try {
			List<MeiosCaptura> meiosArquivos = (List<MeiosCaptura>) getGenericDAO().buscaMeio();
			return meiosArquivos;
			
		} catch (DAOServiceException e) {
			logger.log(Level.ERROR, "Erro em DocumentsService.buscaMeio", e);
		}
		return null;
	}
	
	public MeiosCaptura buscaMeioId(long id) throws ServiceException {
		try {
			MeiosCaptura meiosArquivos = (MeiosCaptura) getGenericDAO().buscaMeioId(id);
			return meiosArquivos;
			
		} catch (DAOServiceException e) {
			logger.log(Level.ERROR, "Erro em DocumentsService.buscaMeioId", e);
		}
		return null;
	}
	
	public MeiosCaptura buscaMeioNome(String nome) throws ServiceException {
		try {
			MeiosCaptura meiosArquivos = (MeiosCaptura) getGenericDAO().buscaMeioNome(nome);
			return meiosArquivos;
			
		} catch (DAOServiceException e) {
			logger.log(Level.ERROR, "Erro em DocumentsService.buscaMeioNome", e);
		}
		return null;
	}
}
