package com.kratonsolution.belian.security.api;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@Getter
@Setter
public class RoleModuleData {
    
	@NonNull
	private String moduleCode;
	
	private String moduleName;
	
	private ModuleGroup moduleGroup;
	
    private boolean read;
    
    private boolean add;
    
    private boolean edit;
    
    private boolean delete;
    
    private boolean print;
}
