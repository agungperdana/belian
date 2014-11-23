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
@Document(collection="unit_of_measure")
@Getter
@Setter
public class UnitOfMeasure
{
	@Id
	private String id;
	
	@Field("code")
	private String code;
	
	@Field("name")
	@Indexed
	private String name;

	@Field("note")
	private String note;
}
