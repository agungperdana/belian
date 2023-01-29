package com.kratonsolution.belian.access.user.api.application;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import com.kratonsolution.belian.access.user.api.UserRoleCommand;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0.0
 */
@Getter
@Setter
public class UserUpdateCommand implements Serializable {

	private static final long serialVersionUID = -2385236525510827913L;

	@NonNull
	private String name;

	@NonNull
	private String email;

	private String organizationCode;

	private String organizationName;

	private boolean enabled;

	private boolean locked;

	private List<UserRoleCommand> roles = new Vector<>();
}
