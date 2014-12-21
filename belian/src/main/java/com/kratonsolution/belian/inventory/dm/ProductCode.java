/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
public class ProductCode
{
	public enum Type{STANDARD,RFID,ISBN,BARCODE}
	
	@Id
	private String id;
	
	@Field("code")
	@Indexed(unique=true,sparse=true)
	private String code;
	
	@Field("type")
	private Type type = Type.STANDARD;
	
	@Field("is_deleted")
	private boolean deleted;
}
