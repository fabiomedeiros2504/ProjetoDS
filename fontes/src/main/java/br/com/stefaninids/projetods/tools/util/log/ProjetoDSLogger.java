package br.com.stefaninids.projetods.tools.util.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProjetoDSLogger {
	
	private static final String LOGGER_PROJECT =		"br.com.stefaninids.PRO";
	private static final String LOGGER_DAO =			"br.com.stefaninids.DAO";
	private static final String LOGGER_SERVICE =		"br.com.stefaninids.SRV";
	private static final String LOGGER_RESOURCE =		"br.com.stefaninids.RES";
	
	private static String logFileName;
	
	static {
		logFileName = "projetods.log";
		System.setProperty("stefaninids.logfile.name", logFileName);
	}
	
	public static Logger getProject(){
		return LogManager.getLogger(LOGGER_PROJECT);
	}
	
	public static Logger getDAO(){
		return LogManager.getLogger(LOGGER_DAO);
	}
	
	public static Logger getService(){
		return LogManager.getLogger(LOGGER_SERVICE);
	}
	
	public static Logger getResource() {
		return LogManager.getLogger(LOGGER_RESOURCE);
	}	
}