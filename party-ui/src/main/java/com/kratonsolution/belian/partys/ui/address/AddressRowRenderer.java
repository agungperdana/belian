package com.kratonsolution.belian.partys.ui.address;

import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.geographic.api.application.GeographicService;
import com.kratonsolution.belian.party.api.AddressData;
import com.kratonsolution.belian.party.api.model.AddressType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class AddressRowRenderer implements RowRenderer<AddressData> {

	@Override
	public void render(Row row, AddressData data, int index) throws Exception {
		
		Listbox type = Components.fullSpanSelect();
		for(AddressType _type:AddressType.values()) {
			
			Listitem listitem = type.appendItem(_type.name(), _type.name());
			if(data.getType()!=null && data.getType().equals(_type)) {
				type.setSelectedItem(listitem);
			}
		}
	
		Listbox geos = Components.fullSpanSelect();
		
		Springs.get(GeographicService.class).getAllGeographics().forEach(geo -> {
			
			Listitem _geo = geos.appendItem(geo.getCode()+" "+geo.getName(), geo.getCode());
			if(data.getLocation() != null && data.getLocation().getCode().equals(geo.getCode())) {
				geos.setSelectedItem(_geo);
			}
		});
		
		row.setAttribute("DATAID", data.getId());
		row.appendChild(Components.checkbox(false));
		row.appendChild(Components.textBox(data.getDescription()));
		row.appendChild(Components.textBox(data.getPostal()));
		row.appendChild(type);
		row.appendChild(Components.checkbox(data.isActive()));
		row.appendChild(geos);
	}
}
