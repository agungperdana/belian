package com.kratonsolution.belian.api.security;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
public class UserData {
    
	@NonNull
	private String name;
    
	@NonNull
    private String email;
	
	private String password;
    
    private boolean enabled;
    
    private boolean expired;
    
    private boolean locked;
    
    private Set<UserRoleData> roles = new HashSet<>();
}
