package com.kratonsolution.belian.security.access.user.api.application;

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
public class UserUpdateCommand {

	@NonNull
    private String email;

    private String name;
    
    private Boolean enabled;
}
