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
import br.com.stefaninids.projetods.entities.MeiosCaptura;
import br.com.stefaninids.projetods.entities.ResponseObj;
import br.com.stefaninids.projetods.service.MeioCapturaService;
import br.com.stefaninids.projetods.service.ServicesController;

@Path("/meios_captura")
public class MeioCapturaResource extends BaseResource {
	
	private static ServicesController servicesController;
	private static MeioCapturaService meioCapturaService;
	
	static {
		servicesController = ServicesController.getInstance();
		meioCapturaService = servicesController.getMeioCapturaService();
	}
	
	public MeioCapturaResource() {
		super();
	}
	
	@Context
	private UriInfo uriInfo;
	
	@GET
	@Path("/consultar_todos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTodosMeios() {
		Response resposta = null;
		
		try {
			List<MeiosCaptura> meios = meioCapturaService.buscaMeio();			
			resposta = ResponseObj.createResponse(meios); 
		} catch (ServiceException e) {
			e.printStackTrace();			
		}
		
		return resposta;
	}
}
