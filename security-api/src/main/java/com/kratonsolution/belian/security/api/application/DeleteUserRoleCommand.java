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
public class DeleteUserRoleCommand implements Serializable {

	private static final long serialVersionUID = -4338260473873043124L;

	@NonNull
	private String userName;
	
	@NonNull
	private String roleCode;
}
