/**
 * 
 */
package com.kratonsolution.belian.ui.partyrelationshiptype;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.general.dm.PartyRelationshipType;

/**
 * @author agungdodiperdana
 *
 */
public class PartyRelationshipTypeRowRenderer implements RowRenderer<PartyRelationshipType>
{

	@Override
	public void render(Row row, PartyRelationshipType data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
