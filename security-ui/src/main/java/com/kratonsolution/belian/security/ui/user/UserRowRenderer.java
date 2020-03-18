package com.kratonsolution.belian.security.ui.user;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.security.api.UserData;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class UserRowRenderer implements RowRenderer<UserData>
{
	@Override
	public void render(Row row, UserData data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getEmail()));
			
			if(data.isEnabled())
				row.appendChild(new Label("Active"));
			else
				row.appendChild(new Label("Inactive"));
		}
	}
}
