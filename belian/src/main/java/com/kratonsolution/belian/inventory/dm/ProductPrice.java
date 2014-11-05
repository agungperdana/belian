/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="product_price")
public class ProductPrice
{
	@Id
	private String id;
	
	private BigDecimal amount;
}
