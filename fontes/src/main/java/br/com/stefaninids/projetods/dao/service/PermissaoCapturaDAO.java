package br.com.stefaninids.projetods.dao.service;

import br.com.stefaninids.projetods.entities.MeiosCaptura;
import br.com.stefaninids.projetods.entities.PermissaoCaptura;
import br.com.stefaninids.projetods.entities.PermissaoCapturaPK;
import br.com.stefaninids.projetods.entities.Usuario;

public interface PermissaoCapturaDAO extends DAOService<PermissaoCaptura, PermissaoCapturaPK> {
	public PermissaoCaptura buscaPermissaoPorUsuario(long id_usuario) throws DAOServiceException;
	public void inserirPermissao(Usuario usuario, MeiosCaptura meio) throws DAOServiceException;
}
