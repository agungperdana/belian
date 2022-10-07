package com.kratonsolution.belian.security.access.role.api.application;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
@Getter
@Setter
public class RoleUpdateCommand {

	@NonNull
    private String name;

    private String description;
    
    private boolean enabled;

    private Set<RoleModuleUpdateCommand> modules = new HashSet<>();
}
