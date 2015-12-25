/**
 * 
 */
package com.kratonsolution.belian.ui.general.companystructure;

import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.ui.util.Dates;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CompanyStructureRowRenderer implements RowRenderer<CompanyStructure>
{

	@Override
	public void render(Row row, CompanyStructure data, int index) throws Exception
	{
		if(data != null)
		{
			row.appendChild(new Checkbox());
			row.appendChild(new Label(Dates.format(data.getFrom())));
			row.appendChild(new Label(Dates.format(data.getTo())));
			row.appendChild(new Label(data.getParent()!=null?data.getParent().getParty().getName():""));
			row.appendChild(new Label(data.getParent()!=null?data.getParent().getType().toString():""));
			row.appendChild(new Label(data.getChild()!=null?data.getChild().getParty().getName():""));
			row.appendChild(new Label(data.getChild()!=null?data.getChild().getType().name():""));
			row.appendChild(new Label(data.getId()));
		}
	}
}
