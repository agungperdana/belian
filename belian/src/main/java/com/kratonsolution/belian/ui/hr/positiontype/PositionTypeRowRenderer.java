/**
 * 
 */
package com.kratonsolution.belian.ui.hr.positiontype;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.hr.dm.PositionType;

/**
 * @author agungdodiperdana
 *
 */
public class PositionTypeRowRenderer implements RowRenderer<PositionType>
{

	@Override
	public void render(Row row, PositionType data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getTitle()));
			row.appendChild(new Label(data.getDescription()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
