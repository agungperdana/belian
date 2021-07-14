package com.kratonsolution.belian.security.ui.user;

import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.access.api.UserData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class UserRowRenderer implements RowRenderer<UserData>
{
	@Override
	public void render(@NonNull Row row, @NonNull UserData data, int index) throws Exception
	{
		row.appendChild(new Checkbox());
		row.appendChild(new Label(data.getName()));
		row.appendChild(new Label(data.getEmail()));
		
		if(data.isEnabled())
			row.appendChild(new Label("Active"));
		else
			row.appendChild(new Label("Inactive"));
		
		row.addEventListener(Events.ON_DOUBLE_CLICK, e->
			EventQueues.lookup(UserUIEvent.class.getSimpleName()).
			publish(UserUIEvent.editForm(data.getName())));
	}
}
