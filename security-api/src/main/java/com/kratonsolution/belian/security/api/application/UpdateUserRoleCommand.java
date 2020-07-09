package com.kratonsolution.belian.security.api.application;

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
public class UpdateUserRoleCommand implements Serializable {

	private static final long serialVersionUID = 3470773803104571155L;

	@NonNull
	private String userName;
	
	@NonNull
	private String roleCode;
	
	private String roleName;
	
	private Boolean enabled;
}
