package com.kratonsolution.belian.partys.ui.organization;

import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

import com.kratonsolution.belian.common.ui.event.UIEvent;
import com.kratonsolution.belian.party.api.OrganizationData;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public class OrganizationRowRenderer implements RowRenderer<OrganizationData>
{	
	@Override
	public void render(Row row, OrganizationData data, int index) throws Exception
	{
		row.appendChild(new Checkbox());
		row.appendChild(new Label(data.getParty().getCode()));
		row.appendChild(new Label(data.getParty().getName()));
		row.appendChild(new Label(data.getParty().getTaxCode()));
		
		row.addEventListener(Events.ON_DOUBLE_CLICK, e->{
			
			EventQueues.lookup(OrganizationUIEvent.class.getSimpleName())
						.publish(new OrganizationUIEvent(UIEvent.EDIT_FORM, data.getParty().getCode()));
		});
	}
}
