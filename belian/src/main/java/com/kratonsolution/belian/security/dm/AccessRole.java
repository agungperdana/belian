/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Setter;
import lombok.Getter;

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
	
	@Field("module_id")
	private String moduleId;
	
	@Field("module_name")
	private String moduleName;
	
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
