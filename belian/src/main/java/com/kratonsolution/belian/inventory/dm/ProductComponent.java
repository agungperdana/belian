/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Agung Dodi Perdana
 *
 */
@Getter
@Setter
public class ProductComponent
{
	@Id
	private String id;
	
	@Field("quantity")
	private BigDecimal quantity = BigDecimal.ONE;
	
	@DBRef
	private Product product;
	
	@Field("note")
	private String note;
	
	@Field("is_deleted")
	private boolean deleted;
}
