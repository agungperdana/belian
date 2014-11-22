/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Setter;
import lombok.Getter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="product_feature")
public class ProductFeature
{
	public enum Type{SIZE,WEIGH,HEIGH,COLOR}
	
	@Id
	private String id;
	
	@Field("value")
	private String value;
	
	@Field("type")
	private String type;
	
	@Field("is_deleted")
	private boolean deleted;
}
