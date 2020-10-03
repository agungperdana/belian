package com.kratonsolution.belian.partys.ui.partyrole;

import java.time.Instant;
import java.util.Date;

import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
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

		Listbox types = Components.fullSpanSelect();
		for(PartyRoleType type:PartyRoleType.values()) {

			Listitem listitem = types.appendItem(type.name(), type.name());
			if(data.getType()!=null && data.getType().equals(type)) {
				types.setSelectedItem(listitem);
			}
		}

		row.appendChild(Components.checkbox(false));
		row.appendChild(Components.fullSpanDatebox(data.getStart()!=null?Date.from(data.getStart()):new Date()));
		row.appendChild(Components.fullSpanDatebox(data.getEnd()!=null?Date.from(data.getEnd()):null));
		row.appendChild(types);
		row.appendChild(new Label(data.getId()));

		row.getChildren().get(1).addEventListener(Events.ON_CHANGE, e->{

			Datebox box = (Datebox)e.getTarget();
			data.setStart(Instant.from(box.getValueInZonedDateTime()));
		});

		row.getChildren().get(2).addEventListener(Events.ON_CHANGE, e->{

			Datebox box = (Datebox)e.getTarget();
			data.setEnd(Instant.from(box.getValueInZonedDateTime()));
		});
		
		types.addEventListener(Events.ON_SELECT, e->data.setType(PartyRoleType.valueOf(types.getSelectedItem().getValue())));
	}
}
