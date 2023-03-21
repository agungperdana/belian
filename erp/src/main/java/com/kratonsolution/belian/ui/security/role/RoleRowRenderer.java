
package com.kratonsolution.belian.ui.security.role;

import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.role.impl.orm.Role;
import com.kratonsolution.belian.ui.util.Components;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RoleRowRenderer implements RowRenderer<Role>
{
	@Override
	public void render(Row row, Role data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(Components.checkbox(data.isUndeleteable(),false));
			row.appendChild(new Label(data.getCode()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getNote()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
