package com.kratonsolution.belian.partys.ui.citizenship;

import java.util.Date;

import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.ui.util.Components;
import com.kratonsolution.belian.common.ui.util.Springs;
import com.kratonsolution.belian.geographic.api.GeographicType;
import com.kratonsolution.belian.geographic.api.application.GeographicService;
import com.kratonsolution.belian.party.api.CitizenshipData;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class CitizenshipRowRenderer implements RowRenderer<CitizenshipData> {

	@Override
	public void render(Row row, CitizenshipData data, int index) throws Exception {
		
		Listbox geos = Components.fullSpanSelect();
		Springs.get(GeographicService.class).getAllByType(GeographicType.COUNTRY).forEach(geo->{
			geos.appendItem(geo.getName(), geo.getCode());
		});
		
		row.appendChild(Components.checkbox(false));
		row.appendChild(Components.fullSpanDatebox(data.getStart()!=null?Date.from(data.getStart()):null));
		row.appendChild(Components.fullSpanDatebox(data.getEnd()!=null?Date.from(data.getEnd()):null));
		row.appendChild(Components.mandatoryTextBox(data.getPassportNumber()));
		row.appendChild(Components.fullSpanDatebox(data.getPassportIssuedDate()!=null?Date.from(data.getPassportIssuedDate()):null));
		row.appendChild(Components.fullSpanDatebox(data.getPassportExpiredDate()!=null?Date.from(data.getPassportExpiredDate()):null));
		row.appendChild(geos);
		row.appendChild(new Label(data.getId()));
	}
}