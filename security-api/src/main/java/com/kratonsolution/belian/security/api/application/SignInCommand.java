package com.kratonsolution.belian.security.api.application;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class SignInCommand implements Serializable {
    
    private static final long serialVersionUID = 7494046782829828087L;

	@NonNull
    private String name;
    
    @NonNull
    private String password;
}
