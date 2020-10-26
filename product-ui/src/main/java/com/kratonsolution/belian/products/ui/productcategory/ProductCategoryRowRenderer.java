package com.kratonsolution.belian.products.ui.productcategory;

import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.products.api.ProductCategoryData;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class ProductCategoryRowRenderer implements RowRenderer<ProductCategoryData>
{	
	@Override
	public void render(Row row, ProductCategoryData data, int index) throws Exception
	{
		row.appendChild(new Checkbox());
		row.appendChild(new Label(data.getName()));
		row.appendChild(new Label(data.getComment()));
		
		row.addEventListener(Events.ON_DOUBLE_CLICK, e->{
			
			EventQueues.lookup(ProductCategoryUIEvent.class.getSimpleName())
						.publish(ProductCategoryUIEvent.editForm(data.getName()));
		});
	}
}
