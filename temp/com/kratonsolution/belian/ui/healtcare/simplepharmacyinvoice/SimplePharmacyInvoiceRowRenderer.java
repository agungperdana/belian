package com.kratonsolution.belian.ui.healtcare.simplepharmacyinvoice;

import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.healtcare.dm.SimplePharmacyInvoice;
import com.kratonsolution.belian.ui.util.Numbers;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SimplePharmacyInvoiceRowRenderer implements RowRenderer<SimplePharmacyInvoice>
{
	@Override
	public void render(Row row, SimplePharmacyInvoice data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(data.getCustomer().getName()));
			row.appendChild(new Label(Numbers.format(data.getAmount())));
			row.appendChild(new Label(data.getNote()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
