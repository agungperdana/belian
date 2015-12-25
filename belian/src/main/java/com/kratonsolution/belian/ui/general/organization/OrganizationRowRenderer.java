/**
 * 
 */
package com.kratonsolution.belian.ui.general.organization;

import java.text.SimpleDateFormat;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

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
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(format.format(data.getBirthDate())));
			row.appendChild(new Label(data.getTaxCode()));
			row.appendChild(new Label(data.getType() != null?data.getType().name():""));
			row.appendChild(new Label(data.getId()));
		}
	}
}
