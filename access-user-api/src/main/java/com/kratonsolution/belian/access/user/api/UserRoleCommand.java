package com.kratonsolution.belian.access.user.api;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class UserRoleCommand {

	@NonNull
	private String roleCode;
	
	@NonNull
	private String roleName;
	
	private boolean enabled;
}
