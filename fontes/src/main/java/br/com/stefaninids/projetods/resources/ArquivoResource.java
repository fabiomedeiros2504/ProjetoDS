package br.com.stefaninids.projetods.resources;

import java.io.File;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.stefaninids.projetods.Constants;
import br.com.stefaninids.projetods.entities.Arquivo;
import br.com.stefaninids.projetods.entities.ResponseObj;
import br.com.stefaninids.projetods.entities.Usuario;
import br.com.stefaninids.projetods.service.ArquivoService;
import br.com.stefaninids.projetods.service.NivelService;
import br.com.stefaninids.projetods.service.ServicesController;
import br.com.stefaninids.projetods.service.UsuarioService;
import br.com.stefaninids.projetods.tools.util.Excel;
import br.com.stefaninids.projetods.tools.util.FormatarData;
import jxl.write.WritableSheet;

@Path("/arquivo")
public class ArquivoResource extends BaseResource {
	
	private static ServicesController servicesController;
	private static ArquivoService arquivoService;
	private static UsuarioService usuarioService;
	private static NivelService nivelService;
	
	static {
		servicesController = ServicesController.getInstance();
		arquivoService = servicesController.getArquivoService();
		usuarioService = servicesController.getUsuarioService();
		nivelService = servicesController.getNivelService();
	}
	
	public ArquivoResource() {
		super();
	}
	
	@Context
	private UriInfo uriInfo;
	
	@GET
	@Path("/consultar")
	public Response consultarEnvio(@Context HttpServletRequest httpServletRequest,
								   @QueryParam("meio_captura") long meio_captura,
								   @QueryParam("tipo_arquivo") long tipo_arquivo,
								   @QueryParam("data") String dataStr,
								   @QueryParam("usuario") long usuario) {
		
		try {
			Usuario usuario_adm = usuarioService.buscaUsuario(httpServletRequest.getHeader("usr"), httpServletRequest.getHeader("pass"));			
			
			if (usuario_adm == null) {
				return ResponseObj.createResponse(404, 1, "Usuário não encontrado para estas credenciais.");
			}
			
			if (!usuario_adm.isAdm(nivelService.buscaNivelCodigo(Constants.CODIGO_ADMINISTRADOR))) {
				return ResponseObj.createResponse(400, 1, "Apenas administradores podem realizar configurações.");
			}		
			
			if (dataStr.equals(""))
				dataStr = "1890-01-01";
			
			Timestamp ts_inicial = FormatarData.toTimestamp(dataStr, 0,0,0);
			Timestamp ts_final = FormatarData.toTimestamp(dataStr, 23, 59, 59);
			
			List<Arquivo> arquivos = arquivoService.buscaArquivos(meio_captura, tipo_arquivo, usuario, ts_inicial, ts_final);
			int coluna;
			int linha = 1;
			final int colunas = 6;
			
			if (arquivos != null) {
				Excel e = new Excel(usuario_adm);
				WritableSheet s = e.criarPlanilha();
				
				Iterator<Arquivo> iteArquivo = arquivos.iterator();
				
				while (iteArquivo.hasNext()) {
					Arquivo arquivo = iteArquivo.next();
					
					for (coluna = 0; coluna < colunas; coluna++) {
						e.escreverDados(coluna, linha, arquivo.retornaPorCodigo(coluna), s);
					}
					
					linha++;
				}
				
				File file = new File(e.finalizarWorkbook());			 
				ResponseBuilder responseBuilder = Response.ok(file);	 
				responseBuilder.header("Content-Disposition", "attachment;filename=" + file.getName());	 
				return responseBuilder.build();
			}
		}catch (Exception e) {
			return ResponseObj.createResponse(500, 1, e.getMessage());
		}
		
		return ResponseObj.createResponse(500, 1, "Ocorreu algum erro durante a operação.");		
	}

}
