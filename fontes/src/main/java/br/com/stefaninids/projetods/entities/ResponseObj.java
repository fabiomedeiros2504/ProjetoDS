package br.com.stefaninids.projetods.entities;

import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import br.com.stefaninids.projetods.tools.util.gson.GsonBuilderUtil;

public class ResponseObj {
	public static Response createResponse(Object object) {
		GsonBuilder gsonBuilder = GsonBuilderUtil.getDefaultBuild();
		gsonBuilder.excludeFieldsWithoutExposeAnnotation();
		Gson gson = gsonBuilder.create();
		String response = gson.toJson(object);
		
		ResponseBuilder builder =  Response.ok(response);
		CacheControl cacheControl = new CacheControl();
		cacheControl.setNoCache(true);
		builder.cacheControl(cacheControl);
		
		return builder.build();
	}
	
	public static Response createResponse(int status, int code, String message) {
		Gson gson = new Gson();
		JsonObject jo = new JsonObject();		
		
		jo.addProperty("status", status);
		jo.addProperty("code", code);
		jo.addProperty("message", message);
		
		return Response.status(status)
				.entity(gson.toJson(jo))
				.type(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + ";charset=utf-8").build();
	}
}
