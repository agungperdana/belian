package com.kratonsolution.belian.partys.ui.physicalcharacteristic;

import java.util.Date;

import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.party.api.PhysicalCharacteristicData;
import com.kratonsolution.belian.party.api.model.PhysicalCharacteristicType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class PhysicalCharacteristicRowRenderer implements RowRenderer<PhysicalCharacteristicData> {

	@Override
	public void render(Row row, PhysicalCharacteristicData data, int index) throws Exception {
		
		Listbox types = Components.fullSpanSelect();
		for(PhysicalCharacteristicType type:PhysicalCharacteristicType.values()) {
			
			Listitem listitem = types.appendItem(type.name(), type.name());
			if(data.getType()!=null && data.getType().equals(type)) {
				types.setSelectedItem(listitem);
			}
		}
		
		row.appendChild(Components.checkbox(false));
		row.appendChild(Components.fullSpanDatebox(data.getStart()!=null?Date.from(data.getStart()):null));
		row.appendChild(Components.fullSpanDatebox(data.getEnd()!=null?Date.from(data.getEnd()):null));
		row.appendChild(Components.mandatoryTextBox(data.getValue()));
		row.appendChild(types);
		row.appendChild(new Label(data.getId()));
	}
}
