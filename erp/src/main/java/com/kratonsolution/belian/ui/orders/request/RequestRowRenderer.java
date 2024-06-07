package com.kratonsolution.belian.ui.orders.request;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.orders.dm.Request;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RequestRowRenderer implements RowRenderer<Request>
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	@Override
	public void render(Row row, Request data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getEntryDate())));
			row.appendChild(new Label(DateTimes.format(data.getRequiredDate())));
			row.appendChild(new Label(DateTimes.format(data.getOrderDate())));
			row.appendChild(new Label(data.getType().display(utils.getLanguage())));
			row.appendChild(new Label(data.getOriginator().getValue()));
			row.appendChild(new Label(data.getResponding().getValue()));
			row.appendChild(new Label(data.getDescription()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
