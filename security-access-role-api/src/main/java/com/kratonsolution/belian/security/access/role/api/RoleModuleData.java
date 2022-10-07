package com.kratonsolution.belian.security.access.role.api;

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
    private String name;

	private String group;

    private boolean read;
    
    private boolean add;
    
    private boolean edit;
    
    private boolean delete;
    
    private boolean print;
}
