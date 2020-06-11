package com.kratonsolution.belian.common.application;

import java.util.HashMap;
import java.util.Map;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
public class MapHelper {

	public static Map<String, String> build(String key, String value) {

		Map<String, String> map = new HashMap<String, String>();
		map.put(key, value);
		return map;
	}

	public static Map<String, Object> withId(@NonNull Object value) {

		Map<String, Object> map = new HashMap<>();
		map.put("id", value);
		return map;
	}

	public static Map<String, Object> withCode(@NonNull Object value) {

		Map<String, Object> map = new HashMap<>();
		map.put("code", value);
		return map;
	}
}
