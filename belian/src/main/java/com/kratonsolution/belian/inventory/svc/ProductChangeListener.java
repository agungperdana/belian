/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductChangeEventListener;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class ProductChangeListener implements ProductChangeEventListener
{
	@Autowired
	private InventoryItemService invenItemService;

	@Override
	public void fireObjectCreated(Product product)
	{
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.inventory.dm.ProductChangeEventListener#fireObjectDeleted(java.lang.String)
	 */
	@Override
	public void fireObjectDeleted(String productId)
	{
		// TODO Auto-generated method stub

	}

}
