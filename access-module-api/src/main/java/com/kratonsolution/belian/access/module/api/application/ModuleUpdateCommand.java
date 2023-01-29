package com.kratonsolution.belian.access.module.api.application;

import java.io.Serializable;

import com.kratonsolution.belian.access.module.api.ModuleGroup;

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
public class ModuleUpdateCommand implements Serializable {

    private static final long serialVersionUID = -9043031618031031905L;

	@NonNull
    private String code;
    
    @NonNull
    private String name;
    
    @NonNull
    private ModuleGroup group;
    
    private String note;
    
    private boolean enabled;
    
	private String lastUpdatedBy;
}
