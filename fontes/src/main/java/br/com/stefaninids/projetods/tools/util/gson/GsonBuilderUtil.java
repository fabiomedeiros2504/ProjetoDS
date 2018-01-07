package br.com.stefaninids.projetods.tools.util.gson;

import java.util.Date;
import java.util.List;

import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;


public class GsonBuilderUtil {

	public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mmZ";
	
	public static GsonBuilder getDefaultNoListBuild() {
		GsonBuilder gsonBuilder = getDefaultBuild();
		gsonBuilder.addSerializationExclusionStrategy(new TypeExclusionStrategy(List.class));
		return gsonBuilder;
	}
	
	public static GsonBuilder getDefaultBuild() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new DateTypeAdapter());
		return gsonBuilder;
	}
	
}
