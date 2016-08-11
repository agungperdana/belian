/**
 * 
 */
package com.kratonsolution.belian.invoice.dm;

import java.io.Serializable;

import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductFeature;
import com.kratonsolution.belian.production.dm.TimeEntry;
import com.kratonsolution.belian.production.dm.WorkEffort;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InvoiceItem implements Serializable
{
	private InvoiceItemType type;
	
	private Product product;
	
	private ProductFeature feature;
	
	private WorkEffort workEffort;
	
	private TimeEntry timeEntry;
	
	private InvoiceAdjustment adjustment;
	
	private InventoryItem inventoryItem;
}
