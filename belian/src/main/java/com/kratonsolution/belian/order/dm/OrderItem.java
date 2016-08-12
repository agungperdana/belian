/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductFeature;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class OrderItem implements Serializable
{
	protected String id = UUID.randomUUID().toString();
	
	protected BigDecimal quantity;
	
	protected BigDecimal untitPrice;
	
	protected Product product;
	
	protected ProductFeature feature;

	protected String note;
}
