package com.kratonsolution.belian.security.ui.role;

import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.access.api.RoleData;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class RoleRowRenderer implements RowRenderer<RoleData>
{
	@Override
	public void render(Row row, RoleData data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getCode()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getNote()));
			
			row.addEventListener(Events.ON_DOUBLE_CLICK, e->{
				
				EventQueues.lookup(RoleUIEvent.class.getSimpleName())
							.publish(RoleUIEvent.editForm(data.getCode()));
			});
		}
	}
}
