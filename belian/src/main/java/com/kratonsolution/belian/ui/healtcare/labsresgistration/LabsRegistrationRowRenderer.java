/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.labsresgistration;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.Dates;
import com.kratonsolution.belian.healtcare.dm.Laboratory;
import com.kratonsolution.belian.ui.util.Components;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LabsRegistrationRowRenderer implements RowRenderer<Laboratory>
{
	@Override
	public void render(Row row, Laboratory data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(data.isPaid()?Components.readOnlyCheckbox():new Checkbox());
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(Dates.format(data.getDate())));
			row.appendChild(new Label(data.getCustomer().getName()));
			row.appendChild(new Label(data.getSales()!=null?data.getSales().getName():""));
			row.appendChild(new Label(data.isPaid()?"PAID":"UNPAID"));
			row.appendChild(new Label(data.getId()));
		}
	}
}
