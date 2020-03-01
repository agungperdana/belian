package com.kratonsolution.belian.api.security.application;

import javax.annotation.Nonnull;

import com.kratonsolution.belian.api.security.ModuleGroup;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class ModuleCreateCommand {
    
	@Nonnull
    private String code;
    
	@Nonnull
    private String name;
    
    private String note;
    
    @Nonnull
    private ModuleGroup group;
    
    private boolean enabled;
}
