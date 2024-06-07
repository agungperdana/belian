
package com.kratonsolution.belian.ui.finance.payments.disbursement;

import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.payments.dm.Disbursement;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.Springs;


/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DisbursementRenderer implements RowRenderer<Disbursement>
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	@Override
	public void render(Row row, Disbursement data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(Components.checkbox(false));
			row.appendChild(new Label(data.getNumber()));
			row.appendChild(new Label(DateTimes.format(data.getEfectiveDate())));
			row.appendChild(new Label(data.getPayer().getValue()));
			row.appendChild(new Label(data.getReceiver().getValue()));
			row.appendChild(new Label(Numbers.format(data.getAmount())));
			row.appendChild(new Label(data.getMethod().display(utils.getLanguage())));
			row.appendChild(new Label(data.getReference()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
