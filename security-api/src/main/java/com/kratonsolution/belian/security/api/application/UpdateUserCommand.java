package com.kratonsolution.belian.security.api.application;

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
public class UpdateUserCommand {
    
    @NonNull
    private String name;
        
    @NonNull
    private String email;
    
    private boolean enabled;
    
    private Vector<UserRoleData> roles = new Vector<>();
}
