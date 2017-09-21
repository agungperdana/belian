/**
 * 
 */
package com.kratonsolution.belian.ui.payment.receipt;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.payment.dm.Receipt;
import com.kratonsolution.belian.ui.util.Numbers;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ReceiptRowRenderer implements RowRenderer<Receipt>
{

	@Override
	public void render(Row row, Receipt data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getDate())));
			row.appendChild(new Label(Strings.isNullOrEmpty(data.getType().getName())?"Receipt":data.getType().getName()));
			row.appendChild(new Label(data.getCurrency().getCode()+" "+Numbers.format(data.getAmount())));
			row.appendChild(new Label(data.getNote()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
