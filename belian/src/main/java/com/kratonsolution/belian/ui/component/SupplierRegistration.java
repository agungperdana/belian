/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import java.util.Collection;
import java.util.Vector;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.procurement.dm.Supplier;
import com.kratonsolution.belian.procurement.dm.SupplierRelationship;
import com.kratonsolution.belian.procurement.svc.SupplierRelationshipService;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class SupplierRegistration extends Window
{
	private Collection<SupplierRegistrationListener> listeners = new Vector<SupplierRegistrationListener>();

	private Vlayout layout = new Vlayout();

	private FormToolbar toolbar = new FormToolbar();
	
	private SupplierRelationshipService service = Springs.get(SupplierRelationshipService.class);

	private Datebox start = Components.currentDatebox();

	private Datebox end = Components.datebox();

	private PartyBox partys = new PartyBox(true);

	private OrganizationList organizations = new OrganizationList();

	public SupplierRegistration()
	{
		setWidth("550px");
		setHeight("450px");
		setClosable(true);
		setPosition("center");

		init();
	}

	private void init()
	{
		Caption caption = new Caption("Supplier Registration");
		caption.setImage("/icons/supplier.png");
		appendChild(caption);
		
		Grid grid = new Grid();
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.setSpan("1");
		grid.getRows().appendChild(RowUtils.row("Start", start));
		grid.getRows().appendChild(RowUtils.row("End", end));
		grid.getRows().appendChild(RowUtils.row("Party", partys));
		grid.getRows().appendChild(RowUtils.row("Company", organizations));
		
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				SupplierRegistration.this.detach();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Supplier supplier = new Supplier();
				supplier.setParty(partys.getParty());

				InternalOrganization organization = new InternalOrganization();
				organization.setParty(organizations.getOrganization());

				SupplierRelationship relationship = new SupplierRelationship();
				relationship.setStart(DateTimes.sql(start.getValue()));
				relationship.setSupplier(supplier);
				relationship.setOrganization(organization);

				service.add(relationship);
				
				for(SupplierRegistrationListener listener:listeners)
					listener.setSupplier(relationship.getSupplier());
			
				detach();
			}
		});
		
		layout.appendChild(toolbar);
		layout.appendChild(grid);

		appendChild(layout);
	}

	public void addListener(SupplierRegistrationListener listener)
	{
		if(listener != null)
			listeners.add(listener);
	}
}
