/**
 * 
 */
package com.kratonsolution.belian.ui.journalentry;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.common.Strings;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class JournalEntryRowRenderer implements RowRenderer<JournalEntry>
{
	@Override
	public void render(Row row, JournalEntry data, int index) throws Exception
	{
		if(data != null)
		{
			Checkbox checkbox = new Checkbox();
			if(data.isAuto() || data.isPosted())
				checkbox.setDisabled(true);
			
			row.appendChild(checkbox);
			row.appendChild(new Label(Dates.format(data.getDate())));
			row.appendChild(new Label(data.getOwner().getName()));
			row.appendChild(new Label(data.getPeriod().getName()));
			row.appendChild(new Label(Strings.safe(data.getNote())));
			row.appendChild(new Label(data.getId()));
		}
	}
}
