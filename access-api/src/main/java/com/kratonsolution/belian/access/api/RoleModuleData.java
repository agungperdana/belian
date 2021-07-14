package com.kratonsolution.belian.access.api;

import java.io.Serializable;

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
public class RoleModuleData implements Serializable {
    
	private static final long serialVersionUID = -6448554535905004190L;

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
