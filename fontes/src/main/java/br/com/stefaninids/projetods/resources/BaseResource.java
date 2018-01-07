package br.com.stefaninids.projetods.resources;

import org.apache.logging.log4j.Logger;

import br.com.stefaninids.projetods.tools.util.log.ProjetoDSLogger;

public abstract class BaseResource {
	protected Logger logger = ProjetoDSLogger.getResource();
}
