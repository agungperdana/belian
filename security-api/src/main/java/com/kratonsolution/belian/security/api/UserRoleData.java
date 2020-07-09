package com.kratonsolution.belian.security.api;

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
public class UserRoleData implements Serializable {
    
    private static final long serialVersionUID = 1015440221886265079L;

	@NonNull
    private String roleCode;
    
    @NonNull
    private String roleName;
            
    private boolean enabled;
}