package com.kratonsolution.belian.security.api.application;

import java.io.Serializable;
import java.util.Vector;

import com.kratonsolution.belian.security.api.UserRoleData;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class UpdateUserCommand implements Serializable {
    
    private static final long serialVersionUID = -2385236525510827913L;

	@NonNull
    private String name;
        
    @NonNull
    private String email;
    
    private boolean enabled;
    
    private Vector<UserRoleData> roles = new Vector<>();
}
