package br.com.stefaninids.projetods.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.stefaninids.projetods.dao.service.ArquivoDAO;
import br.com.stefaninids.projetods.dao.service.DAOServiceException;
import br.com.stefaninids.projetods.entities.Arquivo;
import br.com.stefaninids.projetods.entities.ArquivoPK;

@Named("br.com.stefaninids.projetods.dao.service.ArquivoService")
public class ArquivoService extends AbstractService<ArquivoDAO, Arquivo, ArquivoPK> {
	@Inject
	private ArquivoDAO arquivoDAO;
	
	public ArquivoService() {
		super();
	}
	
	@Override
	protected ArquivoDAO getGenericDAO() {
		return arquivoDAO;
	}
	
	public void salvar(Arquivo arquivo) {
		arquivoDAO.salvar(arquivo);
	}

	public List<Arquivo> buscaArquivos(long meio_captura, long tipo_arquivo, long usuario, Timestamp data_inicial, Timestamp data_final) {
		try {
			List<Arquivo> arquivos = (List<Arquivo>) getGenericDAO().buscaArquivos(meio_captura, tipo_arquivo, usuario, data_inicial, data_final);
			return arquivos;
			
		} catch (DAOServiceException e) {
			e.getStackTrace();
		}
		return null;
	}
}
