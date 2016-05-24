/**
 * 
 */
package com.kratonsolution.belian.ui.inbox;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.tools.dm.Inbox;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InboxRowRenderer implements RowRenderer<Inbox>
{

	@Override
	public void render(Row row, Inbox data, int index) throws Exception
	{
		row.appendChild(new Checkbox());
		row.appendChild(new Label(DateTimes.format(data.getDate())));
		row.appendChild(new Label(data.getContent()));
		row.appendChild(new Label(data.getId()));
	}
}
