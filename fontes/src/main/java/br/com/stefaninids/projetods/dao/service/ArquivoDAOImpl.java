package br.com.stefaninids.projetods.dao.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.stefaninids.projetods.entities.Arquivo;
import br.com.stefaninids.projetods.entities.ArquivoPK;

@Named("br.com.stefaninids.projetods.dao.service.ArquivoDAOImpl")
public class ArquivoDAOImpl extends DAOServiceImpl<Arquivo, ArquivoPK> implements ArquivoDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Arquivo> buscaArquivos(long meio_captura, long tipo_arquivo, long usuario, Timestamp data_inicial, Timestamp data_final) {
		EntityManager entityManager = getEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("Arquivo.retornaArquivo");
			query.setParameter("tipoArquivo", tipo_arquivo);
			query.setParameter("meioCaptura", meio_captura);
			query.setParameter("idUsuario", usuario);
			query.setParameter("dataEnvioInicial", data_inicial);
			query.setParameter("dataEnvioFinal", data_final);
			
			List<Arquivo> arquivos = query.getResultList();
			
			return arquivos;			
		} catch (NoResultException e) {
			return null;			
		} catch (Exception e) {
			throw new DAOServiceException(e.getMessage(), e);
		}
	}
	
}
