package com.kratonsolution.belian.ui.security.user;

import com.kratonsolution.belian.user.api.UserData;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.user.impl.orm.User;
import com.kratonsolution.belian.ui.util.Components;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
public class UserRowRenderer implements RowRenderer<UserData>
{

	@Override
	public void render(Row row, UserData data, int index) throws Exception
	{
		if(data != null)
		{
			if(!data.isDeleteable())
				row.appendChild(Components.readOnlyCheckbox());
			else
				row.appendChild(new Checkbox());
			
			row.appendChild(new Label(data.getUserName()));
			row.appendChild(new Label(""));
			
			if(data.isEnabled())
				row.appendChild(new Label("Active"));
			else
				row.appendChild(new Label("Inactive"));
			
			row.appendChild(new Label(data.getUserName()));
		}
	}
}
