/**
 * 
 */
package com.kratonsolution.belian.ui.product;

import java.text.SimpleDateFormat;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.inventory.dm.Product;

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
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			
			row.appendChild(new Checkbox());
			row.appendChild(new Label(format.format(data.getStart())));
			row.appendChild(new Label(data.getEnd()!=null?format.format(data.getEnd()):""));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getCategory().getName()));
			row.appendChild(new Label(data.getType().name()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
