package com.kratonsolution.belian.ui.procurement.supplier;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.procurement.dm.SupplierRelationship;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SupplierRowRenderer implements RowRenderer<SupplierRelationship>
{
	@Override
	public void render(Row row, SupplierRelationship data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(DateTimes.format(data.getStart())));
			row.appendChild(new Label(DateTimes.format(data.getEnd())));
			row.appendChild(new Label(data.getSupplier().getParty().getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
