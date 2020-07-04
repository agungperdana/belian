package com.kratonsolution.belian.partys.ui.partyclassification;

import java.util.Date;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.party.api.PartyClassificationData;
import com.kratonsolution.belian.party.api.model.PartyClassificationType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class PartyClassificationRowRenderer implements RowRenderer<PartyClassificationData> {

	@Override
	public void render(Row row, PartyClassificationData data, int index) throws Exception {
		
		Listbox type = Components.fullSpanSelect();
		for(PartyClassificationType _type:PartyClassificationType.values()) {
			
			Listitem listitem = type.appendItem(_type.name(), _type.name());
			if(data.getType()!=null && data.getType().equals(_type)) {
				type.setSelectedItem(listitem);
			}
		}
		
		row.setAttribute("DATAID", data.getDataID());
		row.appendChild(Components.checkbox(false));
		row.appendChild(Components.fullSpanDatebox(data.getStart()!=null?Date.from(data.getStart()):new Date()));
		row.appendChild(Components.fullSpanDatebox(data.getEnd()!=null?Date.from(data.getEnd()):null));
		row.appendChild(Components.mandatoryTextBox(data.getValue()));
		row.appendChild(type);
	}
}
