package com.kratonsolution.belian.common.application;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class MapHelper {

	public static Map<String, String> build(String key, String value) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put(key, value);
		return map;
	}
}
