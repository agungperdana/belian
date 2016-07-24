/**
 * 
 */
package com.kratonsolution.belian.ui.general.organization;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.Organization;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class OrganizationRowRenderer implements RowRenderer<Organization>
{
	@Override
	public void render(Row row, Organization data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getIdentity()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(DateTimes.format(data.getBirthDate())));
			row.appendChild(new Label(data.getTaxCode()));
			row.appendChild(new Label(data.getType() != null?data.getType().name():""));
			row.appendChild(new Label(data.getId()));
		}
	}
}
