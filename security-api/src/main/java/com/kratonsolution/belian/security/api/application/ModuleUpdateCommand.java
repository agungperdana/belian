package com.kratonsolution.belian.security.api.application;

import com.kratonsolution.belian.security.api.ModuleGroup;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class ModuleUpdateCommand {

    @NonNull
    private String code;
    
    @NonNull
    private String name;
    
    @NonNull
    private ModuleGroup group;
    
    private String note;
    
    private boolean enabled;
}
