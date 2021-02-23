package com.kratonsolution.belian.security.api.application;

import java.io.Serializable;

import javax.annotation.Nonnull;

import com.kratonsolution.belian.security.api.ModuleGroup;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class ModuleCreateCommand implements Serializable {
    
	private static final long serialVersionUID = 6526962330287609499L;

	@Nonnull
    private String code;
    
	@Nonnull
    private String name;
    
    private String note;
    
    @Nonnull
    private ModuleGroup group;
    
    private boolean enabled;
}
