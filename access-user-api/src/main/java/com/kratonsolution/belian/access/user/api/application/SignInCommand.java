package com.kratonsolution.belian.access.user.api.application;

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
public class SignInCommand implements Serializable {
    
    private static final long serialVersionUID = 7494046782829828087L;

	@NonNull
    private String username;
    
    @NonNull
    private String password;
}
