/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
public class ProductFeature
{
	public enum Type{SIZE,WEIGH,HEIGH,COLOR}
	
	@Id
	private String id;
	
	@Field("value")
	private String value;
	
	@Field("type")
	private Type type = Type.WEIGH;
	
	@Field("note")
	private String note;
	
	@Field("is_deleted")
	private boolean deleted;
}
