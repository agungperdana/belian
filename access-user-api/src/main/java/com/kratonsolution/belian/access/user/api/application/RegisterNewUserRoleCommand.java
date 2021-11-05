package com.kratonsolution.belian.access.user.api.application;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Setter
public class RegisterNewUserRoleCommand implements Serializable {

	private static final long serialVersionUID = 9002305938231695375L;

	@NonNull
	private String userName;
	
	@NonNull
	private String roleCode;
	
	@NonNull
	private String roleName;
	
	private boolean enabled;
}
