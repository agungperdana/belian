package com.kratonsolution.belian.security.api.application;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class RoleCreateCommand {
    
    @NonNull
    private String code;
    
    @NonNull
    private String name;
    
    private String note;
    
    private boolean enabled;    
    
    private Set<RoleModuleCommand> modules = new HashSet<RoleModuleCommand>();
}
