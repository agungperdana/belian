/**
 * 
 */
package com.kratonsolution.belian.general.dm;

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
public class Contact
{
	public enum Type{CELLPHONE,HOMEPHONE,OFFICEPHONE,PAGER,EMAIL,POSTBOX}
	
	@Id
	private String id;
	
	@Field("description")
	private String description;

	@Field("type")
	private Type type = Type.OFFICEPHONE;
	
	@Field("is_active")
	private boolean active;
	
	@Field("is_deleted")
	private boolean deleted;
}
