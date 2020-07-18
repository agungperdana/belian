package com.kratonsolution.belian.partys.ui.address;

import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.geographic.api.GeographicData;
import com.kratonsolution.belian.geographic.api.application.GeographicService;
import com.kratonsolution.belian.party.api.AddressData;
import com.kratonsolution.belian.party.api.PartyGeographicInfoData;
import com.kratonsolution.belian.party.api.model.AddressType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class AddressRowRenderer implements RowRenderer<AddressData> {

	@Override
	public void render(Row row, AddressData data, int index) throws Exception {
		
		Listbox types = Components.fullSpanSelect();
		for(AddressType type:AddressType.values()) {
			
			Listitem listitem = types.appendItem(type.name().toString(), type.name());
			if(data.getType()!=null && data.getType().equals(type)) {
				types.setSelectedItem(listitem);
			}
		}
	
		Listbox geos = Components.fullSpanSelect();
		Springs.get(GeographicService.class).getAllGeographics().forEach(geo -> {
			
			Listitem _geo = geos.appendItem(geo.getCode()+" "+geo.getName(), geo.getCode());
			if(data.getLocation() != null && data.getLocation().getCode().equals(geo.getCode())) {
				geos.setSelectedItem(_geo);
			}
		});
		
		row.appendChild(Components.checkbox(false));
		row.appendChild(Components.textBox(data.getDescription()));
		row.appendChild(Components.textBox(data.getPostal()));
		row.appendChild(types);
		row.appendChild(Components.checkbox(data.isActive()));
		row.appendChild(geos);
		row.appendChild(new Label(data.getId()));
		
		row.getChildren().get(1).addEventListener(Events.ON_CHANGING, e->data.setDescription(((InputEvent)e).getValue()));
		row.getChildren().get(2).addEventListener(Events.ON_CHANGING, e->data.setPostal(((InputEvent)e).getValue()));
		row.getChildren().get(3).addEventListener(Events.ON_SELECT, e->data.setType(AddressType.valueOf(types.getSelectedItem().getValue())));
		row.getChildren().get(4).addEventListener(Events.ON_CHECK, e->data.setActive(((CheckEvent)e).isChecked()));
		
		geos.addEventListener(Events.ON_SELECT, e->{
			
			GeographicData geo = Springs.get(GeographicService.class).getByCode(geos.getSelectedItem().getValue());
			data.setLocation(new PartyGeographicInfoData(geo.getCode(), geo.getName()));
		});
	}
}
