/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

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
public class Container
{
	public enum Type{ROOM,BIN,BAREL,FILEDRAWER,SHELF}
	
	@Id
	private String id;
	
	@Field("name")
	private String name;
	
	@Field("type")
	private String type;
	
	@Field("is_deleted")
	private boolean deleted;
}
