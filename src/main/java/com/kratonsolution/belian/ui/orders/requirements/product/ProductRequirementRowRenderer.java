/**
 * 
 */
package com.kratonsolution.belian.ui.orders.requirements.product;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.requirement.dm.ProductRequirement;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductRequirementRowRenderer implements RowRenderer<ProductRequirement>
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	@Override
	public void render(Row row, ProductRequirement data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(DateTimes.format(data.getCreationDate())));
			row.appendChild(new Label(DateTimes.format(data.getRequiredDate())));
			row.appendChild(new Label(data.getDescription()));
			row.appendChild(new Label(data.getReason()));
			row.appendChild(new Label(data.getType().display(utils.getLanguage())));
			row.appendChild(new Label(data.getId()));
		}
	}
}
