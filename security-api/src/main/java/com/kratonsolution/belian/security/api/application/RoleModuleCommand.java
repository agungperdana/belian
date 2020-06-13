package com.kratonsolution.belian.security.api.application;

import com.kratonsolution.belian.security.api.ModuleGroup;

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
public class RoleModuleCommand {
    
    @NonNull
    private String moduleCode;
    
    @NonNull
    private String moduleName;
    
    private ModuleGroup moduleGroup;
    
    private boolean read;
    
    private boolean add;
    
    private boolean edit;
    
    private boolean delete;
    
    private boolean print;
}
