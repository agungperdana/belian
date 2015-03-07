/**
 * 
 */
package com.kratonsolution.belian.ui.role;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.security.dm.Role;

/**
 * @author agungdodiperdana
 *
 */
public class RoleRowRenderer implements RowRenderer<Role>
{

	@Override
	public void render(Row row, Role data, int index) throws Exception
	{
		row.appendChild(new Checkbox());
		row.appendChild(new Label(data.getCode()));
		row.appendChild(new Label(data.getName()));
		row.appendChild(new Label(data.getNote()));
		row.appendChild(new Label(data.getId()));
	}
}
