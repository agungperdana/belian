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
public class AccessRole
{
	@Id
	private String id;
	
	@DBRef
	private Module module;
	
	@Field("is_can_read")
	private boolean canRead;
	
	@Field("is_can_update")
	private boolean canUpdate;
	
	@Field("is_can_delete")
	private boolean canDelete;
	
	@Field("is_can_create")
	private boolean canCreate;

	@Field("is_can_print")
	private boolean canPrint;
}
