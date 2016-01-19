/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.inventory.dm.UnitOfMeasure;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductUOMBox extends Listitem implements ProductUoMListener
{

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.ui.component.ProductUoMListener#fireProductSelected(com.kratonsolution.belian.inventory.dm.UnitOfMeasure)
	 */
	@Override
	public void fireProductSelected(UnitOfMeasure uom)
	{
		getChildren().clear();
		appendChild(new Listitem(uom.getLabel(),uom.getValue()));
	}
}
