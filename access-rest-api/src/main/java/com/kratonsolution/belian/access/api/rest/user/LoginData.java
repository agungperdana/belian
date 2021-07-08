package com.kratonsolution.belian.access.api.rest.user;

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
public class LoginData {
	
	@NonNull
	private String username;
	
	@NonNull
	private String password;
}
