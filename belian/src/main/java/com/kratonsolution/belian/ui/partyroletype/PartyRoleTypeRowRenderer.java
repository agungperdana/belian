/**
 * 
 */
package com.kratonsolution.belian.ui.partyroletype;

import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.general.dm.PartyRoleType;
import com.kratonsolution.belian.ui.util.Components;

/**
 * @author agungdodiperdana
 *
 */
public class PartyRoleTypeRowRenderer implements RowRenderer<PartyRoleType>
{
	@Override
	public void render(Row row, PartyRoleType data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(Components.readOnlyCheckbox());
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
