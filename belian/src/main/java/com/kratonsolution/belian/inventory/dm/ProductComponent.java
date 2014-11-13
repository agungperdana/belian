/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
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
	
	@Field("amount")
	private BigDecimal amount = BigDecimal.ONE;
	
	@Field("product_id")
	private String productId;
	
	@Field("product_name")
	private String productName;
	
	@Field("is_deleted")
	private boolean deleted;
}
