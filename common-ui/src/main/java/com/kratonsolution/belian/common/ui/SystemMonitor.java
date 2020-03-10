package com.kratonsolution.belian.common.ui;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * 
 * this class for managing running application (module), something like system monitor in linux
 */
public class SystemMonitor {

	public Map<String, ApplicationModule> runningModules = new HashMap<>();
	
	public void register(ApplicationModule module) {
		
		if(!runningModules.containsKey(module.getName())) {
			runningModules.put(module.getName(), module);
		}
	}
}
