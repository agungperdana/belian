package com.kratonsolution.belian.access.role.api;

import java.io.Serializable;
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
public class RoleData implements Serializable {
    
    private static final long serialVersionUID = -4075374676161919723L;

	@NonNull
    private String code;
    
    @NonNull
    private String name;
    
    private String note;
    
    private boolean enabled;
    
    private Set<RoleModuleData> modules = new HashSet<RoleModuleData>();
}
