package com.kratonsolution.belian.security.api.application;

import java.io.Serializable;

import com.kratonsolution.belian.security.api.ModuleGroup;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
@Getter
@Setter
public class ModuleCreateCommand implements Serializable {
    
	private static final long serialVersionUID = 6526962330287609499L;

	@NonNull
    private String code;
    
	@NonNull
    private String name;
    
    private String note;
    
    @NonNull
    private ModuleGroup group;
    
    private boolean enabled;
}
