package com.kratonsolution.belian.security.access.role.api.application;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@ToString
@Getter
@Setter
public class RoleModuleCreateCommand {

	@NonNull
    private String name;

    @NonNull
    private String group;

    private boolean read;
    
    private boolean add;
    
    private boolean edit;
    
    private boolean delete;
    
    private boolean print;
}
