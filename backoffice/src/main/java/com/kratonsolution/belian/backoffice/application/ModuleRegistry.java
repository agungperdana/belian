package com.kratonsolution.belian.backoffice.application;

import java.util.Collection;
import java.util.Vector;

import org.springframework.stereotype.Service;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class ModuleRegistry {

	private Vector<String> names = new Vector<>();
	
	public void register(@NonNull String moduleName) {
		
		if(!names.contains(moduleName)) {
			names.add(moduleName);
		}
	}
	
	public Collection<String> getRegisteredModules() {
		
		return names;
	}
}
