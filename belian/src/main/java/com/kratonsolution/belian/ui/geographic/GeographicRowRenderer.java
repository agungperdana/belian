/**
 * 
 */
package com.kratonsolution.belian.ui.geographic;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.general.dm.Geographic;

/**
 * @author agungdodiperdana
 *
 */
public class GeographicRowRenderer implements RowRenderer<Geographic>
{
	@Override
	public void render(Row row, Geographic data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getCode()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getType().toString()));
			row.appendChild(new Label(data.getNote()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
