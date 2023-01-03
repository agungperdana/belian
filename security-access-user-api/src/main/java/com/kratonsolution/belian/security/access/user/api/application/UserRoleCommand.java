package com.kratonsolution.belian.security.access.user.api.application;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
@Data
public class UserRoleCommand implements Serializable {
    
	private static final long serialVersionUID = 6526962330287609499L;

	@NonNull
    private String roleName;

    @NonNull
    private Boolean enabled = Boolean.FALSE;

}
