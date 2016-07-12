package com.kratonsolution.belian.ui.healtcare.clinicsales;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.healtcare.dm.Medication;
import com.kratonsolution.belian.ui.util.Components;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ClinicSalesRowRenderer implements RowRenderer<Medication>
{
	@Override
	public void render(Row row, Medication data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(data.isPaid()?Components.readOnlyCheckbox():new Checkbox());
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(data.getCustomer()!=null?data.getCustomer().getName():"Anonymous"));
			row.appendChild(new Label(data.getSales()!=null?data.getSales().getName():""));
			row.appendChild(new Label(data.getStatus().name()));
			row.appendChild(new Label(data.getId()));
		}
	}
}