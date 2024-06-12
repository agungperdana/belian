package com.kratonsolution.belian.ui.inventory.facility;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.facility.impl.orm.Facility;
import com.kratonsolution.belian.ui.Dashboard;
import com.kratonsolution.belian.ui.util.Flow;

public class FacilityDashboard extends Dashboard
{
	private FacilityNav nav = new FacilityNav();
	
	public FacilityDashboard(Facility facility)
	{
		super();
		
		appendChild(nav);
		appendChild(canvas);
		
		canvas.appendChild(new FacilityForm(facility,nav));
		
		initNav(facility);
	}
	
	private void initNav(Facility facility)
	{
		nav.setAddMode(facility.getId().equals("0"));
		
		nav.getTable().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Flow.next(task.getFocused(), new FacilityGridContent());
			}
		});
		
		nav.getForm().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				canvas.clear();
				canvas.appendChild(new FacilityForm(facility,nav));
			}
		});
		
		nav.getOrganization().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				canvas.clear();
				canvas.appendChild(new FacilityOrganizationForm(facility));
			}
		});
		
		nav.getContainer().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				canvas.clear();
				canvas.appendChild(new ContainerContent(facility));
			}
		});
	}
}
