/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Document(collection="tax")
@Getter
@Setter
public class Tax
{
	@Id
	private String id;
	
	@Field("name")
	private String name;
	
	@Field("value")
	private BigDecimal value = BigDecimal.ZERO;
	
	@Field("note")
	private String note;
}
