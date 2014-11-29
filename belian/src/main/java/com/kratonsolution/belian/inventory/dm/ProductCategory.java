/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="product_category")
public class ProductCategory
{
	@Id
	private String id;

	@Field("name")
	@Indexed(unique=true)
	private String name;
	
	@Field("description")
	private String note;
}
