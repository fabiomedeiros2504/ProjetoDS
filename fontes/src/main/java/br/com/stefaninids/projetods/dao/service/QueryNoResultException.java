package br.com.stefaninids.projetods.dao.service;

public class QueryNoResultException extends ServiceException {
	
	private static final long serialVersionUID = 1L;

	public QueryNoResultException() {
		super();
	}
	public QueryNoResultException(int codigoErro, String message) {
		super(codigoErro, message);
	}
	public QueryNoResultException(int codigoErro, Throwable cause) {
		super(codigoErro, cause);
	}
	public QueryNoResultException(int codigoErro, String message, Throwable cause) {
		super(codigoErro, message, cause);
	}
}
