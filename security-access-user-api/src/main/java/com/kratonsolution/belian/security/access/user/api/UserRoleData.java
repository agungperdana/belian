package com.kratonsolution.belian.security.access.user.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 2.0
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleData {

	private String roleName;

	private Boolean enabled;
}
