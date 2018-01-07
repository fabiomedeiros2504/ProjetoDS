package br.com.stefaninids.projetods.dao.service;

import br.com.stefaninids.projetods.entities.PermissaoArquivo;
import br.com.stefaninids.projetods.entities.PermissaoArquivoPK;
import br.com.stefaninids.projetods.entities.TiposArquivos;
import br.com.stefaninids.projetods.entities.Usuario;

public interface PermissaoArquivoDAO extends DAOService<PermissaoArquivo, PermissaoArquivoPK> {
	public void inserirPermissao(Usuario usuario, TiposArquivos tipo) throws DAOServiceException;
	public PermissaoArquivo buscaPermissaoPorUsuario(long id_usuario) throws DAOServiceException;
}
