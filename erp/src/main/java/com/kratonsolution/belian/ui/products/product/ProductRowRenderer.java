
package com.kratonsolution.belian.ui.products.product;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.product.impl.orm.Product;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductRowRenderer implements RowRenderer<Product>
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	@Override
	public void render(Row row, Product data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getIntroductionDate())));
			row.appendChild(new Label(DateTimes.format(data.getDiscontinuationDate())));
			row.appendChild(new Label(DateTimes.format(data.getSupportDiscontinuationDate())));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getType()!=null?data.getType().display(utils.getLanguage()):""));
			row.appendChild(new Label(data.getId()));
		}
	}
}
