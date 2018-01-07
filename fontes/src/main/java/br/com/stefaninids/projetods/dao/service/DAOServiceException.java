package br.com.stefaninids.projetods.dao.service;

public class DAOServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DAOServiceException() {
		super();
	}
	
	public DAOServiceException(String message) {
		super(message);
	}
	
	public DAOServiceException(Throwable cause) {
		super(cause);
	}
	public DAOServiceException(String message, Throwable cause) {
		super(message, cause);
	}	
}
