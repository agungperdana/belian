/**
 * 
 */
package com.kratonsolution.belian.ui.uom;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.inventory.dm.UnitOfMeasure;

/**
 * @author agungdodiperdana
 *
 */
public class UOMRowRenderer implements RowRenderer<UnitOfMeasure>
{

	@Override
	public void render(Row row, UnitOfMeasure data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getCode()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getNote()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
