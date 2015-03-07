/**
 * 
 */
package com.kratonsolution.belian.ui.module;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.security.dm.Module;

/**
 * @author agungdodiperdana
 *
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
			row.appendChild(new Label(data.getNote()));
			row.appendChild(new Label(data.getId()));
		}
	}
}
