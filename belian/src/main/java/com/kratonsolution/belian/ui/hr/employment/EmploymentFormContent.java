/**
 * 
 */
package com.kratonsolution.belian.ui.hr.employment;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;

import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.hr.dm.EmploymentApplication;
import com.kratonsolution.belian.hr.svc.EmploymentApplicationService;
import com.kratonsolution.belian.hr.svc.EmploymentService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmploymentFormContent extends FormContent
{	
	private EmploymentService service = Springs.get(EmploymentService.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private EmploymentApplicationService applicationService = Springs.get(EmploymentApplicationService.class);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private Listbox applications = Components.newSelect();
	
	private Listbox employee = Components.newSelect();
	
	private Listbox employer = Components.newSelect();
	
	public EmploymentFormContent()
	{
		super();
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
				EmploymentWindow window = (EmploymentWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
//				Employment employment = new Employment();
//				employment.setFrom(start.getValue());
//				employment.setTo(end.getValue());
//				employment.setType(PartyRelationship.Type.EMPLOYMENT);
//				
//				Employee person = new Employee();
//				person.setFrom(start.getValue());
//				person.setTo(end.getValue());
//				person.setParty(personService.findOne(Components.string(employee)));
//				
//				Employer org = new Employer();
//				org.setFrom(start.getValue());
//				org.setTo(end.getValue());
//				org.setParty(organizationService.findOne(Components.string(employer)));
//				
//				employment.setParent(org);
//				employment.setChild(person);
//				
//				service.add(employment);
				
				EmploymentWindow window = (EmploymentWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		for(EmploymentApplication application:applicationService.findAllByStatusType(EmploymentApplication.StatusType.ACCEPTED))
		{
			applications.appendChild(
					new Listitem(application.getApplicant().getLabel()+" - "+application.getPosition().getType().getLabel(),
							application.getId()));
		}
		
		applications.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				EmploymentApplication application = applicationService.findOne(Components.string(applications));
				if(application != null)
				{
					employee.appendChild(new Listitem(application.getApplicant().getLabel(), application.getApplicant().getValue()));
					employee.setSelectedIndex(0);
				}
			}
		});
			
		Row row1 = new Row();
		row1.appendChild(new Label("Start Date"));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label("End Date"));
		row2.appendChild(end);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Employer"));
		row3.appendChild(employer);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Application"));
		row4.appendChild(applications);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Employee"));
		row5.appendChild(employee);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
}