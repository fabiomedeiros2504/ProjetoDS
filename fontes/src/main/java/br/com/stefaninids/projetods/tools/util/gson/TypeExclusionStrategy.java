package br.com.stefaninids.projetods.tools.util.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class TypeExclusionStrategy implements ExclusionStrategy {

	private final Class<?> _class;
	
	public TypeExclusionStrategy(Class<?> clazz) {
		_class = clazz;
	}
	
	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return clazz == _class;
	}

	@Override
	public boolean shouldSkipField(FieldAttributes fieldAttributes) {		
		return false;
	}

}
