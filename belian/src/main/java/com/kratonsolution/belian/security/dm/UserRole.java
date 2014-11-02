/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
public class UserRole implements GrantedAuthority
{
	@Id
	private String id;
	
	@Field("role_id")
	private String roleId;
	
	@Field("role_name")
	private String roleName;

	@Field("enabled")
	private boolean enabled;

	@Override
	public String getAuthority()
	{
		return getRoleId();
	}
}
