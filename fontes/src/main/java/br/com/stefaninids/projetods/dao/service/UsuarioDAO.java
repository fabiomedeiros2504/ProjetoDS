package br.com.stefaninids.projetods.dao.service;

import br.com.stefaninids.projetods.entities.Usuario;
import br.com.stefaninids.projetods.entities.UsuarioPK;

public interface UsuarioDAO extends DAOService<Usuario, UsuarioPK> {
	public Usuario buscaUsuario(String login, String password) throws DAOServiceException;
	public void inserirUsuario(Usuario usuario) throws DAOServiceException;
	public Usuario buscaUsuarioId(long id)  throws DAOServiceException;
}
