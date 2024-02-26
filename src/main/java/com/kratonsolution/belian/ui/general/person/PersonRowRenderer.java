/**
 * 
 */
package com.kratonsolution.belian.ui.general.person;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.partys.dm.Person;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PersonRowRenderer implements RowRenderer<Person>
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	@Override
	public void render(Row row, Person data, int index) throws Exception
	{
		if(data != null)
		{
			Checkbox checkbox = Components.checkbox(false);
			checkbox.setDisabled(data.isSystem());
			
			row.appendChild(checkbox);
			row.appendChild(new Label(data.getCode()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getBirthPlace()!=null?data.getBirthPlace().getName():""));
			row.appendChild(new Label(DateTimes.format(data.getBirthDate())));
			row.appendChild(new Label(data.getTaxCode()));
			row.appendChild(new Label(data.getGender().display(utils.getLanguage())));
			row.appendChild(new Label(data.getId()));
		}
	}
}
