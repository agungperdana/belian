package com.kratonsolution.belian.security.ui.module;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.security.api.ModuleData;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class ModuleRowRenderer implements RowRenderer<ModuleData>
{	
	@Override
	public void render(Row row, ModuleData data, int index) throws Exception
	{
		row.appendChild(new Checkbox());
		row.appendChild(new Label(data.getCode()));
		row.appendChild(new Label(data.getName()));
		row.appendChild(new Label(data.getGroup().name()));
	}
}
