package com.kratonsolution.belian.security.access.module.api.application;

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
public class ModuleUpdateCommand {

	@NonNull
    private String name;

    private String description;
    
    private Boolean enabled;
}
