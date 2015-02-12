/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.math.BigDecimal;

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
@Document(collection="tax")
public class Tax
{
	@Id
	private String id;
	
	@Field("code")
	@Indexed(unique=true,name="tax_code_index")
	private String code;
	
	@Field("name")
	@Indexed(unique=true,name="tax_name_index")
	private String name;
	
	@Field("value")
	private BigDecimal value = BigDecimal.ZERO;
}
