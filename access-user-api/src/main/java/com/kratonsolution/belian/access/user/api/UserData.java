package com.kratonsolution.belian.access.user.api;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.checkerframework.checker.nullness.qual.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 1.0
 */
@Getter
@Setter
public class UserData implements Serializable {
    
	private static final long serialVersionUID = 3403743802200817381L;

	@NonNull
	private String name;
    
	@NonNull
    private String email;
	
	private String organizationCode;
	
	private String organizationName;
	
	@JsonIgnore
	private String password;
    
    private boolean enabled;
    
    private boolean expired;
    
    private boolean locked;
    
    private Set<UserRoleData> roles = new HashSet<>();
}
