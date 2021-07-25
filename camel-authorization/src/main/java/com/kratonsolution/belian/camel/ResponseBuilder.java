package com.kratonsolution.belian.camel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */
public class ResponseBuilder {

	public static Map<String, Object> error(Exception exception) {

		Map<String, Object> map = new HashMap<>();
		map.put("status", false);
		map.put("message", exception.getMessage());

		return map;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> success(Object result) {

		Map<String, Object> map = new HashMap<>();
		map.put("status", true);
		map.put("result", result);
		
		
		if(result instanceof Collection) {
			map.put("length", ((Collection<Object>)result).size());
		}

		return map;
	}

	public static Map<String, Object> success(Map<String, Object> resultMap) {

		Map<String, Object> map = new HashMap<>();
		map.put("status", true);
		map.putAll(resultMap);

		return map;
	}
}
