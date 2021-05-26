package com.kratonsolution.belian.security.api.application;

import java.io.Serializable;

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
public class RoleFilter implements Serializable {
	
	private static final long serialVersionUID = -669938368966200185L;

	@NonNull
	private String key;
}
