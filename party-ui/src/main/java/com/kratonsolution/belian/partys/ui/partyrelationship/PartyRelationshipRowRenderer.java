package com.kratonsolution.belian.partys.ui.partyrelationship;

import java.util.Date;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.party.api.PartyRelationshipData;
import com.kratonsolution.belian.party.api.application.PartyService;
import com.kratonsolution.belian.party.api.model.PartyRelationshipType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class PartyRelationshipRowRenderer implements RowRenderer<PartyRelationshipData> {

	@Override
	public void render(Row row, PartyRelationshipData data, int index) throws Exception {
		
		Listbox type = Components.fullSpanSelect();
		for(PartyRelationshipType _type:PartyRelationshipType.values()) {
			
			Listitem listitem = type.appendItem(_type.name(), _type.name());
			if(data.getType()!=null && data.getType().equals(_type)) {
				type.setSelectedItem(listitem);
			}
		}
		
		Listbox party = Components.fullSpanSelect();
		Springs.get(PartyService.class).getAllPartys().forEach(p->{
			
			Listitem itm = party.appendItem(p.getCode()+" "+p.getName(), p.getCode());
			if(!Strings.isNullOrEmpty(data.getToPartyCode()) && data.getToPartyCode().equals(p.getCode())) {
				party.setSelectedItem(itm);
			}
		});
		
		row.setAttribute("DATAID", data.getId());
		row.appendChild(Components.checkbox(false));
		row.appendChild(Components.fullSpanDatebox(data.getStart()!=null?Date.from(data.getStart()):new Date()));
		row.appendChild(Components.fullSpanDatebox(data.getEnd()!=null?Date.from(data.getEnd()):null));
		row.appendChild(party);
		row.appendChild(type);
	}
}
