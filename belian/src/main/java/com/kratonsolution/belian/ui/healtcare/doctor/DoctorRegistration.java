/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctor;

import java.util.Collection;
import java.util.Vector;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.healtcare.dm.Doctor;
import com.kratonsolution.belian.healtcare.dm.DoctorRelationship;
import com.kratonsolution.belian.healtcare.svc.DoctorService;
import com.kratonsolution.belian.healtcare.svc.DoctorTypeService;
import com.kratonsolution.belian.ui.FormToolbar;
import com.kratonsolution.belian.ui.component.PersonBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class DoctorRegistration extends Window
{
	private Collection<DoctorRegistrationListener> listeners = new Vector<DoctorRegistrationListener>();

	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private DoctorService service = Springs.get(DoctorService.class);
	
	private DoctorTypeService doctorTypeService = Springs.get(DoctorTypeService.class);
	
	private Vlayout layout = new Vlayout();

	private FormToolbar toolbar = new FormToolbar();

	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();

	private PersonBox person = new PersonBox(true);

	private Listbox types = Components.newSelect(doctorTypeService.findAll(),true);
	
	private Listbox companys = Components.newSelect(utils.getOrganization());

	public DoctorRegistration()
	{
		setWidth("550px");
		setHeight("450px");
		setClosable(true);
		setPosition("center");

		init();
	}

	private void init()
	{
		Caption caption = new Caption("Doctor Registration");
		caption.setImage("/icons/doctor.png");
		appendChild(caption);
		
		Grid grid = new Grid();
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.setSpan("1");
		grid.getRows().appendChild(RowUtils.row("Start", start));
		grid.getRows().appendChild(RowUtils.row("End", end));
		grid.getRows().appendChild(RowUtils.row("Company", companys));
		grid.getRows().appendChild(RowUtils.row("Type", types));
		grid.getRows().appendChild(RowUtils.row("Person", person));
		
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				DoctorRegistration.this.detach();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				if(person.getPerson() == null)
					throw new WrongValueException(person,"Person box cannot be empty.");
				
				DoctorRelationship relationship = new DoctorRelationship();
				relationship.setStart(DateTimes.sql(start.getValue()));
				relationship.setEnd(DateTimes.sql(end.getValue()));
				relationship.setCategory(doctorTypeService.findOne(Components.string(types)));
				
				Doctor doctor = new Doctor();
				doctor.setStart(DateTimes.sql(start.getValue()));
				doctor.setEnd(DateTimes.sql(end.getValue()));
				doctor.setParty(person.getPerson());
				
				InternalOrganization organization = new InternalOrganization();
				organization.setStart(DateTimes.sql(start.getValue()));
				organization.setEnd(DateTimes.sql(end.getValue()));
				organization.setParty(utils.getOrganization());
				
				relationship.setDoctor(doctor);
				relationship.setOrganization(organization);
				
				service.add(relationship);
				
				for(DoctorRegistrationListener listener:listeners)
					listener.setDoctor(relationship);
			
				detach();
			}
		});
		
		layout.appendChild(toolbar);
		layout.appendChild(grid);

		appendChild(layout);
	}

	public void addListener(DoctorRegistrationListener listener)
	{
		listeners.add(listener);
	}
}
