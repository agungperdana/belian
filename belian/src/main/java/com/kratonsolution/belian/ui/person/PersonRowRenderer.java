/**
 * 
 */
package com.kratonsolution.belian.ui.person;

import java.text.SimpleDateFormat;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.general.dm.Person;

/**
 * @author agungdodiperdana
 *
 */
public class PersonRowRenderer implements RowRenderer<Person>
{

	@Override
	public void render(Row row, Person data, int index) throws Exception
	{
		if(data != null)
		{
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(format.format(data.getBirthDate())));
			row.appendChild(new Label(data.getTaxCode()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
