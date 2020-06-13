package com.kratonsolution.belian.security.api.application;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class ModuleFilter {
 
    private String key;
	
	ModuleFilter() {}
	
	public ModuleFilter(@NonNull String key) {
		this.key = key;
	}
}
