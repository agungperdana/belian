package com.kratonsolution.belian.backoffice.ui;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.Desktop;

import com.kratonsolution.belian.common.ui.ApplicationModule;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * 
 * this class for managing running application (module), something like system monitor in linux
 */
public class SystemMonitor {

	private static String SYSTEM_MONITOR = "SYSTEM_MONITOR";
	
	public Map<String, ApplicationModule> runningModules = new HashMap<>();
	
	public void register(ApplicationModule module) {
		
		if(!runningModules.containsKey(module.getName())) {
			runningModules.put(module.getName(), module);
		}
	}
	
	public static SystemMonitor attach(@NonNull SystemMonitor monitor, @NonNull Desktop desktop) {
		
		desktop.setAttribute(SYSTEM_MONITOR, monitor);
		return monitor;
	}
	
	public static SystemMonitor get(@NonNull Desktop desktop) {
		return (SystemMonitor)desktop.getAttribute(SYSTEM_MONITOR);
	}
}
