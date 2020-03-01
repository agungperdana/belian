package com.kratonsolution.belian.api.security;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class RoleModuleData {
    
	@NonNull
	private ModuleData module;
	
    private boolean read;
    
    private boolean add;
    
    private boolean edit;
    
    private boolean delete;
    
    private boolean print;
}
