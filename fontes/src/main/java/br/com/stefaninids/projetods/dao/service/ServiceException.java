package br.com.stefaninids.projetods.dao.service;

public class ServiceException extends Exception {
	private int codigoErro = 1;

	private static final long serialVersionUID = 1L;
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(int codigoErro, String message) {
		super(message);
		this.codigoErro = codigoErro;
	}
	
	public ServiceException(int codigoErro, Throwable cause) {
		super(cause);
		this.codigoErro = codigoErro;
	}
	
	public ServiceException(int codigoErro, String message, Throwable cause) {
		super(message, cause);
		this.codigoErro = codigoErro;
	}
	public int getCodigoErro() {
		return codigoErro;
	}
	
	
	
}
