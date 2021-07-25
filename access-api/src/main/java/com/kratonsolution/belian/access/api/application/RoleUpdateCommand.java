package com.kratonsolution.belian.access.api.application;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
public class RoleUpdateCommand implements Serializable {
 
    private static final long serialVersionUID = 4915477311846745294L;

	@NonNull
    private String code;
    
    private String name;
    
    private String note;
    
    private boolean enabled;
    
    private Set<RoleModuleCommand> modules = new HashSet<RoleModuleCommand>();
}
