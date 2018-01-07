package br.com.stefaninids.projetods.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.stefaninids.projetods.dao.service.ServiceException;
import br.com.stefaninids.projetods.entities.ResponseObj;
import br.com.stefaninids.projetods.entities.TiposArquivos;
import br.com.stefaninids.projetods.service.ServicesController;
import br.com.stefaninids.projetods.service.TipoArquivoService;

@Path("/tipo_arquivo")
public class TipoArquivoResource extends BaseResource {
	
	private static ServicesController servicesController;
	private static TipoArquivoService tipoArquivoService;
	
	static {
		servicesController = ServicesController.getInstance();
		tipoArquivoService = servicesController.getTipoArquivoService();
	}
	
	public TipoArquivoResource() {
		super();
	}
	
	@Context
	private UriInfo uriInfo;
	
	@GET
	@Path("/consultar_todos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTodosTipos() {
		Response resposta = null;
		
		try {
			List<TiposArquivos> tipos = tipoArquivoService.buscaTipo();			
			resposta = ResponseObj.createResponse(tipos);
		} catch (ServiceException e) {
			e.printStackTrace();			
		}
		
		return resposta;
	}
}