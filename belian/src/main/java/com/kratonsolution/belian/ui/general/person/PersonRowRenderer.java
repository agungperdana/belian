/**
 * 
 */
package com.kratonsolution.belian.ui.general.person;

import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.ui.util.Components;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PersonRowRenderer implements RowRenderer<Person>
{

	@Override
	public void render(Row row, Person data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(Components.checkbox(false));
			row.appendChild(new Label(data.getIdentity()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(DateTimes.format(data.getBirthDate())));
			row.appendChild(new Label(data.getGender().toString()));
			row.appendChild(new Label(data.getMaritalStatus().toString()));
			row.appendChild(new Label(data.getTaxCode()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
