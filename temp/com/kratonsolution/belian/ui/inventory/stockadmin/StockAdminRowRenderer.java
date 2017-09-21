/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.stockadmin;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.inventory.dm.StockAdmin;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class StockAdminRowRenderer implements RowRenderer<StockAdmin>
{

	@Override
	public void render(Row row, StockAdmin data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getEmployee().getParty().getName()));
			row.appendChild(new Label(data.getOrganization().getParty().getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
