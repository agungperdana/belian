/**
 * 
 */
package com.kratonsolution.belian.ui.organizationaccount;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.accounting.dm.OrganizationAccount;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrganizationAccountRowRenderer implements RowRenderer<OrganizationAccount>
{

	@Override
	public void render(Row row, OrganizationAccount data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getOrganization().getName()));
			row.appendChild(new Label(data.isActive()?"Active":"Inactive"));
			row.appendChild(new Label(data.getNote()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
