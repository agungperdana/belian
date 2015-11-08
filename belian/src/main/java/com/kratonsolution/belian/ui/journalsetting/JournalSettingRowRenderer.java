/**
 * 
 */
package com.kratonsolution.belian.ui.journalsetting;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.accounting.dm.JournalSetting;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class JournalSettingRowRenderer implements RowRenderer<JournalSetting>
{

	@Override
	public void render(Row row, JournalSetting data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getOrganization().getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
