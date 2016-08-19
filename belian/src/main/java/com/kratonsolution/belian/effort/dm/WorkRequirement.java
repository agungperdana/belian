/**
 * 
 */
package com.kratonsolution.belian.effort.dm;

import java.math.BigDecimal;

import com.kratonsolution.belian.asset.dm.Asset;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.order.dm.Requirement;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkRequirement extends Requirement
{
	private BigDecimal quantity = BigDecimal.ZERO;
	
	private Deliverable deliverable;
	
	private Asset asset;
	
	private Product product;
}
