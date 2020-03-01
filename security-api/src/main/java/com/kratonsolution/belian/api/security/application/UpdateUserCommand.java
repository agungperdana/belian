package com.kratonsolution.belian.api.security.application;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class UpdateUserCommand {
    
    @NonNull
    private String name;
        
    private boolean enabled;
}
