package com.kratonsolution.belian.common.ui;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ModuleRegistry {

	private Map<String, ApplicationModule> registry = new HashMap<>();
	
	public void registerModule(ApplicationModule module) {
		
		if(!registry.containsKey(module.getName())) {
			registry.put(module.getName(), module);
		}
	}
}
