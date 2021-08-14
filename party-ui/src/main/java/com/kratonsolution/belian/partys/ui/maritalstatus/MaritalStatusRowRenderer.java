package com.kratonsolution.belian.partys.ui.maritalstatus;

import java.util.Arrays;

import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.party.api.MaritalStatusData;
import com.kratonsolution.belian.party.api.model.MaritalStatusType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class MaritalStatusRowRenderer implements RowRenderer<MaritalStatusData> {

	@Override
	public void render(Row row, MaritalStatusData data, int index) throws Exception {
		
		Listbox types = Components.fullSpanSelect();
		
		Arrays.asList(MaritalStatusType.values()).forEach(ob -> {
			Listitem itm = types.appendItem(ob.name(), ob.name());
			if(ob.equals(data.getType())) {
				types.setSelectedItem(itm);
			}
		});
		
		row.appendChild(Components.checkbox(false));
		row.appendChild(Components.fullSpanDatebox(data.getStart()));
		row.appendChild(Components.fullSpanDatebox(data.getEnd()));
		row.appendChild(types);
		row.appendChild(new Label(data.getId()));
	}
}
