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
import org.zkoss.zul.Row;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.hr.dm.Employment;
import com.kratonsolution.belian.hr.svc.EmploymentApplicationService;
import com.kratonsolution.belian.hr.svc.EmploymentService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.PersonBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmploymentEditContent extends FormContent
{	
	private Row row;
	
	private EmploymentService service = Springs.get(EmploymentService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private EmploymentApplicationService applicationService = Springs.get(EmploymentApplicationService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private Listbox applications = Components.newSelect();
	
	private PersonBox persons = new PersonBox(false);
	
	private OrganizationList employer = new OrganizationList();
	
	public EmploymentEditContent(Row row)
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
				Flow.next(getParent(), new EmploymentGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				
				Flow.next(getParent(), new EmploymentGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{		
		Employment employment = service.findOne(RowUtils.id(row));
		if(employment != null)
		{
			start.setValue(employment.getStart());
			end.setValue(employment.getEnd());
			employer.setOrganization(employment.getInternalOrganization().getOrganization());
			persons.setPerson((Person)employment.getEmployee().getParty());
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
			
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
		row4.appendChild(new Label("Person"));
		row4.appendChild(persons);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Application"));
		row5.appendChild(applications);

		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
}
