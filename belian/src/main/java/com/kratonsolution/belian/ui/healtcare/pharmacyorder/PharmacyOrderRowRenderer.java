package com.kratonsolution.belian.ui.healtcare.pharmacyorder;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.healtcare.dm.MedicalSales;
import com.kratonsolution.belian.healtcare.svc.MedicalSalesService;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PharmacyOrderRowRenderer implements RowRenderer<MedicalSales>
{
	private MedicalSalesService service = Springs.get(MedicalSalesService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	@Override
	public void render(Row row, MedicalSales data, int index) throws Exception
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
