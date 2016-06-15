/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.supplier;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.procurement.dm.SupplierRelationship;
import com.kratonsolution.belian.procurement.svc.SupplierRelationshipService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.PartyBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SupplierEditContent extends FormContent
{	
	private SupplierRelationshipService service = Springs.get(SupplierRelationshipService.class);

	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private PartyBox partys = new PartyBox(true);
	
	private OrganizationList organizations = new OrganizationList();

	private Row row;

	public SupplierEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new SupplierGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				SupplierRelationship relationship = service.findOne(RowUtils.id(row));
				if(relationship != null)
				{
					relationship.setEnd(DateTimes.sql(end.getValue()));
					service.edit(relationship);
				}
				
				Flow.next(getParent(), new SupplierGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		SupplierRelationship relationship = service.findOne(RowUtils.id(row));
		if(relationship != null)
		{
			start.setValue(relationship.getStart());
			end.setValue(relationship.getEnd());
			partys.setParty(relationship.getSupplier().getParty());
			organizations.setOrganization(relationship.getOrganization().getOrganization());
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			
			Row row1 = new Row();
			row1.appendChild(new Label("Start"));
			row1.appendChild(start);
			
			Row row2 = new Row();
			row2.appendChild(new Label("End"));
			row2.appendChild(end);
			
			Row row3 = new Row();
			row3.appendChild(new Label("Party"));
			row3.appendChild(partys);
			
			Row row4 = new Row();
			row4.appendChild(new Label("Organization"));
			row4.appendChild(organizations);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
		}
	}
}
