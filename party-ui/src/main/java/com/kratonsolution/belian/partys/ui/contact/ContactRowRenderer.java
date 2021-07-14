package com.kratonsolution.belian.partys.ui.contact;

import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.party.api.ContactData;
import com.kratonsolution.belian.party.api.model.ContactType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class ContactRowRenderer implements RowRenderer<ContactData> {

	@Override
	public void render(Row row, ContactData data, int index) throws Exception {
		
		Listbox types = Components.fullSpanSelect();
		for(ContactType type:ContactType.values()) {
			
			Listitem listitem = types.appendItem(type.toString(), type.name());
			if(data.getType()!=null && data.getType().equals(type)) {
				types.setSelectedItem(listitem);
			}
		}
		
		row.appendChild(Components.checkbox(false));
		row.appendChild(Components.textBox(data.getContact()));
		row.appendChild(types);
		row.appendChild(Components.checkbox(data.isActive()));
		row.appendChild(new Label(data.getId()));
		
		row.getChildren().get(1).addEventListener(Events.ON_CHANGING, e->data.setContact(((InputEvent)e).getValue()));
		row.getChildren().get(2).addEventListener(Events.ON_SELECT, e->data.setType(ContactType.valueOf(types.getSelectedItem().getValue())));
		row.getChildren().get(3).addEventListener(Events.ON_CHECK, e->data.setActive(((CheckEvent)e).isChecked()));
	}
}
