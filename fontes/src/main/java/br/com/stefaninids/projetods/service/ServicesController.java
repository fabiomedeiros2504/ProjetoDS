package br.com.stefaninids.projetods.service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;

@Named("br.com.stefaninids.projetods.service.ServicesController")
public class ServicesController {
	
	@Resource
	private ApplicationContext context = null;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	private TipoArquivoService tipoArquivoService;
	
	@Inject
	private MeioCapturaService meioCapturaService;
	
	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private NivelService nivelService;
	
	@Inject
	private ArquivoService arquivoService;
	
	@Inject
	private PermissaoCapturaService permissaoCapturaService;
	
	@Inject 
	private PermissaoArquivoService permissaoArquivoService;
	
	private static ServicesController instance;
	
	private ServicesController() {
		super();
	}
	
	@PostConstruct
	public void init() {
		instance = (ServicesController) context.getBean("br.com.stefaninids.projetods.service.ServicesController");		
	}
	
	public EntityTransaction getTransaction(){
		return entityManager.getTransaction();
	}
	
	public static final ServicesController getInstance() {
		return instance;
	}
	
	public TipoArquivoService getTipoArquivoService() {
		return tipoArquivoService;
	}		
	
	public MeioCapturaService getMeioCapturaService() {
		return meioCapturaService;
	}		
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}	
	
	public NivelService getNivelService() {
		return nivelService;
	}
	
	public ArquivoService getArquivoService() {
		return arquivoService;
	}
	
	public PermissaoArquivoService getPermissaoArquivoService() {
		return permissaoArquivoService;
	}
	
	public PermissaoCapturaService getPermissaoCapturaService() {
		return permissaoCapturaService;
	}
}
