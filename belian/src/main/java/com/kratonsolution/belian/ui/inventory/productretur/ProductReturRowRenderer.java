/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.productretur;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.inventory.dm.ProductRetur;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductReturRowRenderer implements RowRenderer<ProductRetur>
{

	@Override
	public void render(Row row, ProductRetur data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(data.getOrganization().getName()));
			row.appendChild(new Label(data.getSupplier().getName()));
			row.appendChild(new Label(data.getFacility().getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
