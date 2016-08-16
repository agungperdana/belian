/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductFeature;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class OrderItem implements Serializable
{
	protected String id = UUID.randomUUID().toString();
	
	protected BigDecimal quantity = BigDecimal.ONE;
	
	protected BigDecimal untitPrice = BigDecimal.ONE;
	
	protected Product product;
	
	protected ProductFeature feature;

	protected String note;
	
	@OneToMany(mappedBy="item",cascade=CascadeType.ALL,orphanRemoval=true)
	protected Set<OrderTerm> terms = new HashSet<>();
}
