/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
public class Address
{
	public enum Type{HOME,OFFICE,WAREHOUSE}
	
	@Id
	private String id;
	
	@Field("description")
	private String description;
		
	@Field("postal")
	private String postal;
	
	@Field("is_active")
	private boolean active;
	
	@Field("type")
	private Type type = Type.OFFICE;
	
	@Field("is_deleted")
	private boolean deleted;

	@DBRef
	private Geographic city;
	
	@DBRef
	private Geographic province;
	
	@DBRef
	private Geographic country;
}
