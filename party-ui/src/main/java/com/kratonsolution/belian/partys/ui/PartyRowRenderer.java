package com.kratonsolution.belian.partys.ui;

import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.ui.event.UIEvent;
import com.kratonsolution.belian.party.api.PartyData;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class PartyRowRenderer implements RowRenderer<PartyData>
{	
	@Override
	public void render(Row row, PartyData data, int index) throws Exception
	{
		row.appendChild(new Checkbox());
		row.appendChild(new Label(data.getCode()));
		row.appendChild(new Label(data.getName()));
		row.appendChild(new Label(data.getTaxCode()));
		row.appendChild(new Label(data.getType().name()));
		
		row.addEventListener(Events.ON_DOUBLE_CLICK, e->{
			
			EventQueues.lookup(PartyUIEvent.class.getSimpleName())
						.publish(new PartyUIEvent(UIEvent.EDIT_FORM, data.getCode()));
		});
	}
}
