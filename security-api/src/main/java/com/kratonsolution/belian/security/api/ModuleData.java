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
public class ModuleData {
    
	@NonNull
    private String code;
    
	@NonNull
    private String name;
    
    private String note;
    
    @NonNull
    private ModuleGroup group;
    
    private boolean enabled;
}
