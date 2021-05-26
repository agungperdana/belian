package com.kratonsolution.belian.access.api.application;

import java.io.Serializable;

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
public class UserCreateCommand implements Serializable {
    
    private static final long serialVersionUID = -9174276394230314838L;

	@NonNull
    private String name;
    
    @NonNull
    private String email;
    
    @NonNull
    private String password;
        
    private boolean enabled;
}
