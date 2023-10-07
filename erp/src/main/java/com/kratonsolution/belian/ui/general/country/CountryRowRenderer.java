package com.kratonsolution.belian.ui.general.country;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.country.impl.orm.Country;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
public class CountryRowRenderer implements RowRenderer<Country>
{	
	@Override
	public void render(Row row, Country data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getCode()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
