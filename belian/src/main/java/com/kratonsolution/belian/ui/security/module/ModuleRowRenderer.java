/**
 * 
 */
package com.kratonsolution.belian.ui.security.module;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.security.dm.Module;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ModuleRowRenderer implements RowRenderer<Module>
{	
	@Override
	public void render(Row row, Module data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(data.getCode()));
			row.appendChild(new Label(data.getName()));
			row.appendChild(new Label(data.getGroup().name()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
