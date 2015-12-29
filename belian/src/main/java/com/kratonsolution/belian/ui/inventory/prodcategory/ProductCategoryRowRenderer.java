/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.prodcategory;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.inventory.dm.ProductCategory;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductCategoryRowRenderer implements RowRenderer<ProductCategory>
{

	@Override
	public void render(Row row, ProductCategory data, int index) throws Exception
	{
		if(data != null)
		{
			Checkbox checkbox = new Checkbox();
			if(!data.isDeleteable())
					checkbox.setDisabled(true);
			
			row.appendChild(checkbox);
			row.appendChild(new Label(data.getCode()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getNote()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
