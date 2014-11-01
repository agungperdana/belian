/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
public class UserRole
{
	@Id
	private String id;
	
	@Field("role_id")
	private String roleId;
	
	@Field("role_name")
	private String roleName;

	@Field("enabled")
	private boolean enabled;
}
