package com.kratonsolution.belian.security.api;

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
public class ModuleData implements Serializable {
    
	private static final long serialVersionUID = -1510690541332344917L;

	@NonNull
    private String code;
    
	@NonNull
    private String name;
    
    private String note;
    
    @NonNull
    private ModuleGroup group;
    
    private boolean enabled;
}
