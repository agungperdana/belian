package com.kratonsolution.belian.security.access.user.api.application;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
@Data
public class UserCreateCommand implements Serializable {
    
	private static final long serialVersionUID = 6526962330287609499L;

	@NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;
    
    @NonNull
    private String source;

    @NonNull
    private Boolean enabled = Boolean.FALSE;

    private List<UserRoleCommand> roles = new ArrayList<>();
}
