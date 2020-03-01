package com.kratonsolution.belian.api.security.application;

import java.util.HashSet;
import java.util.Set;

import com.kratonsolution.belian.api.security.RoleModuleData;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class RoleUpdateCommand {
 
    @NonNull
    private String code;
    
    private String note;
    
    private boolean enabled;
    
    private Set<RoleModuleData> modules = new HashSet<RoleModuleData>();
}
