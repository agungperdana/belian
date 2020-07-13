package com.kratonsolution.belian.partys.ui.contact;

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
		
		Listbox type = Components.fullSpanSelect();
		for(ContactType _type:ContactType.values()) {
			
			Listitem listitem = type.appendItem(_type.name(), _type.name());
			if(data.getType()!=null && data.getType().equals(_type)) {
				type.setSelectedItem(listitem);
			}
		}
		
		row.setAttribute("DATAID", data.getId());
		row.appendChild(Components.checkbox(false));
		row.appendChild(Components.textBox(data.getContact()));
		row.appendChild(type);
		row.appendChild(Components.checkbox(data.isActive()));
	}
}
