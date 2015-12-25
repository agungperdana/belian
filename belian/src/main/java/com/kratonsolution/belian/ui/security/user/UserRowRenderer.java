/**
 * 
 */
package com.kratonsolution.belian.ui.security.user;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.security.dm.User;
import com.kratonsolution.belian.ui.util.Components;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class UserRowRenderer implements RowRenderer<User>
{

	@Override
	public void render(Row row, User data, int index) throws Exception
	{
		if(data != null)
		{
			if(!data.isDeleteable())
				row.appendChild(Components.readOnlyCheckbox());
			else
				row.appendChild(new Checkbox());
			
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getEmail()));
			
			if(data.isEnabled())
				row.appendChild(new Label("Active"));
			else
				row.appendChild(new Label("Inactive"));
			
			row.appendChild(new Label(data.getId()));
		}
	}
}
