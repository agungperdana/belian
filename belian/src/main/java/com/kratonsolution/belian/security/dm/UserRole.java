/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

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
	
	@DBRef
	private Role role;

	@Field("enabled")
	private boolean enabled;

	@Field("is_deleted")
	private boolean deleted;
}