package br.com.stefaninids.projetods.resources;

import java.io.Reader;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

import br.com.stefaninids.projetods.Constants;
import br.com.stefaninids.projetods.dao.service.ServiceException;
import br.com.stefaninids.projetods.entities.MeiosCaptura;
import br.com.stefaninids.projetods.entities.PermissaoArquivo;
import br.com.stefaninids.projetods.entities.PermissaoCaptura;
import br.com.stefaninids.projetods.entities.ResponseObj;
import br.com.stefaninids.projetods.entities.TiposArquivos;
import br.com.stefaninids.projetods.entities.Usuario;
import br.com.stefaninids.projetods.service.MeioCapturaService;
import br.com.stefaninids.projetods.service.NivelService;
import br.com.stefaninids.projetods.service.PermissaoArquivoService;
import br.com.stefaninids.projetods.service.PermissaoCapturaService;
import br.com.stefaninids.projetods.service.ServicesController;
import br.com.stefaninids.projetods.service.TipoArquivoService;
import br.com.stefaninids.projetods.service.UsuarioService;

@Path("/usuario")
public class UsuarioResource extends BaseResource {
	
	private static ServicesController servicesController;
	private static UsuarioService usuarioService;
	private static NivelService nivelService;
	private static PermissaoArquivoService permissaoArquivoService;
	private static PermissaoCapturaService permissaoCapturaService;
	private static TipoArquivoService tipoArquivoService;
	private static MeioCapturaService meioCapturaService;
	
	private Gson gson;
	
	static {
		servicesController = ServicesController.getInstance();
		usuarioService = servicesController.getUsuarioService();
		nivelService = servicesController.getNivelService();
		tipoArquivoService = servicesController.getTipoArquivoService();	
		meioCapturaService = servicesController.getMeioCapturaService();
		permissaoArquivoService = servicesController.getPermissaoArquivoService();
		permissaoCapturaService = servicesController.getPermissaoCapturaService();
	}
	
	public UsuarioResource() {
		super();
	}
	
	@Context
	private UriInfo uriInfo;
	
	@POST
	@Path("/inserir")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuarioLogin(@Context HttpServletRequest httpServletRequest, Reader reader) {
		gson = new Gson();
		
		try {
			Usuario usuario = usuarioService.buscaUsuario(httpServletRequest.getHeader("usr"), httpServletRequest.getHeader("pass"));			
			
			if (usuario == null) {
				return ResponseObj.createResponse(404, 1, "Usuário não encontrado para estas credenciais.");
			}
			
			if (!usuario.isAdm(nivelService.buscaNivelCodigo(Constants.CODIGO_ADMINISTRADOR))) {
				return ResponseObj.createResponse(400, 1, "Apenas administradores podem realizar configurações.");
			}			
			
			Usuario novo_usuario = gson.fromJson(reader, Usuario.class);	
			
			usuarioService.salvar(novo_usuario);
			
			return ResponseObj.createResponse(200, 1, "Usuário inserido com sucesso!"); 
		} catch (ServiceException e) {
			e.printStackTrace();			
		}
		
		return ResponseObj.createResponse(500, 1, "Ocorreu algum erro durante a solicitação.");
	}
	
	@POST
	@Path("/inserir/permissao_arquivo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserePermissaoArquivo(@Context HttpServletRequest httpServletRequest, Reader reader) {
		gson = new Gson();
		
		try {
			Usuario usuario = usuarioService.buscaUsuario(httpServletRequest.getHeader("usr"), httpServletRequest.getHeader("pass"));			
			
			if (usuario == null) {
				return ResponseObj.createResponse(404, 1, "Usuário não encontrado para estas credenciais.");
			}
			
			if (!usuario.isAdm(nivelService.buscaNivelCodigo(Constants.CODIGO_ADMINISTRADOR))) {
				return ResponseObj.createResponse(400, 1, "Apenas administradores podem realizar configurações.");
			}			
			
			PermissaoArquivo permissao = gson.fromJson(reader, PermissaoArquivo.class);	
			
			Usuario usuario_permissao = usuarioService.buscaUsuarioId(permissao.getUsuario());
			
			if (usuario_permissao == null) {
				return ResponseObj.createResponse(404, 1, "Usuário que receberá a permissão não existe.");
			}
			
			TiposArquivos tipo_permissao = tipoArquivoService.buscaTipoId(permissao.getTipo_Arquivo());
			
			if (tipo_permissao == null) {
				return ResponseObj.createResponse(404, 1, "Tipo de Arquivo não existe.");
			}
						
			permissaoArquivoService.inserirPermissao(usuario_permissao, tipo_permissao);
			
			return ResponseObj.createResponse(200, 1, "Permissão inserida com sucesso!"); 
		} catch (ServiceException e) {
			e.printStackTrace();			
		}
		
		return ResponseObj.createResponse(500, 1, "Ocorreu algum erro durante a solicitação.");
	}
	
	@POST
	@Path("/inserir/permissao_captura")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserePermissaoCaptura(@Context HttpServletRequest httpServletRequest, Reader reader) {
		gson = new Gson();
		
		try {
			Usuario usuario = usuarioService.buscaUsuario(httpServletRequest.getHeader("usr"), httpServletRequest.getHeader("pass"));			
			
			if (usuario == null) {
				return ResponseObj.createResponse(404, 1, "Usuário não encontrado para estas credenciais.");
			}
			
			if (!usuario.isAdm(nivelService.buscaNivelCodigo(Constants.CODIGO_ADMINISTRADOR))) {
				return ResponseObj.createResponse(400, 1, "Apenas administradores podem realizar configurações.");
			}			
			
			PermissaoCaptura permissao = gson.fromJson(reader, PermissaoCaptura.class);	
			
			Usuario usuario_permissao = usuarioService.buscaUsuarioId(permissao.getUsuario());
			
			if (usuario_permissao == null) {
				return ResponseObj.createResponse(404, 1, "Usuário que receberá a permissão não existe.");
			}
			
			MeiosCaptura meio_permissao = meioCapturaService.buscaMeioId(permissao.getTipo_captura());
			
			if (meio_permissao == null) {
				return ResponseObj.createResponse(404, 1, "Tipo de Captura não existe.");
			}
						
			permissaoCapturaService.inserirPermissao(usuario_permissao, meio_permissao);
			
			return ResponseObj.createResponse(200, 1, "Permissão inserida com sucesso!"); 
		} catch (ServiceException e) {
			e.printStackTrace();			
		}
		
		return ResponseObj.createResponse(500, 1, "Ocorreu algum erro durante a solicitação.");
	}
}
