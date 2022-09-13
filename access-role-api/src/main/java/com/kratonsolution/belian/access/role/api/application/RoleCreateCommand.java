package com.kratonsolution.belian.access.role.api.application;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 * @version 2.0.1
 */
@Getter
@Setter
@ToString
public class RoleCreateCommand implements Serializable {
    
    private static final long serialVersionUID = -6324651912880037639L;

	@NonNull
    private String code;
    
    @NonNull
    private String name;
    
    private String note;
    
    private boolean enabled;

    private Set<RoleModuleCreateCommand> modules = new HashSet<>();
}
