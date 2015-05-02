/**
 * 
 */
package com.kratonsolution.belian.ui.product;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * @author agungdodiperdana
 *
 */
public class ProductRowRenderer implements RowRenderer<Product>
{

	@Override
	public void render(Row row, Product data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(Dates.format(data.getStart())));
			row.appendChild(new Label(Dates.format(data.getEnd())));
			row.appendChild(new Label(data.getCode()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getCategory().getName()));
			row.appendChild(new Label(data.getType().name()));
			row.appendChild(new Label(data.getUom().getCode()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
