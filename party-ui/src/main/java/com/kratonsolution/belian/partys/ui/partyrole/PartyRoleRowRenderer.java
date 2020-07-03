package com.kratonsolution.belian.partys.ui.partyrole;

import java.util.Date;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.party.api.PartyRoleData;
import com.kratonsolution.belian.party.api.model.PartyRoleType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class PartyRoleRowRenderer implements RowRenderer<PartyRoleData> {

	@Override
	public void render(Row row, PartyRoleData data, int index) throws Exception {
		
		Listbox type = Components.fullSpanSelect();
		for(PartyRoleType _type:PartyRoleType.values()) {
			
			Listitem listitem = type.appendItem(_type.name(), _type.name());
			if(data.getType()!=null && data.getType().equals(_type)) {
				type.setSelectedItem(listitem);
			}
		}
		
		row.setAttribute("DATAID", data.getDataID());
		row.appendChild(Components.checkbox(false));
		row.appendChild(Components.fullSpanDatebox(data.getStart()!=null?Date.from(data.getStart()):new Date()));
		row.appendChild(Components.fullSpanDatebox(data.getEnd()!=null?Date.from(data.getEnd()):null));
		row.appendChild(type);
	}
}
