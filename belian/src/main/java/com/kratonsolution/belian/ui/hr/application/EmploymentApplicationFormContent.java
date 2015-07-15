/**
 * 
 */
package com.kratonsolution.belian.ui.hr.application;

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

import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.hr.dm.EmploymentApplication;
import com.kratonsolution.belian.hr.dm.EmploymentApplication.SourceType;
import com.kratonsolution.belian.hr.dm.EmploymentApplication.StatusType;
import com.kratonsolution.belian.hr.svc.EmploymentApplicationService;
import com.kratonsolution.belian.hr.svc.PositionService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class EmploymentApplicationFormContent extends FormContent
{	
	private EmploymentApplicationService service = Springs.get(EmploymentApplicationService.class);

	private PersonService personService = Springs.get(PersonService.class);
	
	private PositionService positionService = Springs.get(PositionService.class);
	
	private Datebox date = Components.currentDatebox();

	private Listbox types = Components.newSelect();

	private Listbox sources = Components.newSelect();

	private Listbox positions = Components.newSelect(positionService.findAll(),true);

	private Listbox applicants = Components.newSelect(personService.findAll(),true);
	
	private Listbox referals = Components.newSelect(personService.findAll(),false);

	public EmploymentApplicationFormContent()
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
				EmploymentApplicationWindow window = (EmploymentApplicationWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				EmploymentApplication application = new EmploymentApplication();
				application.setApplicant(personService.findOne(Components.string(applicants)));
				application.setDate(date.getValue());
				application.setPosition(positionService.findOne(Components.string(positions)));
				application.setSourceType(SourceType.valueOf(Components.string(sources)));
				application.setStatusType(StatusType.valueOf(Components.string(types)));

				if(referals.getSelectedCount() > 0)
					application.setReferal(personService.findOne(Components.string(referals)));
				
				service.add(application);
				
				EmploymentApplicationWindow window = (EmploymentApplicationWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		for(EmploymentApplication.StatusType statusType:StatusType.values())
			types.appendChild(new Listitem(statusType.name(), statusType.name()));
		
		for(SourceType sourceType:SourceType.values())
			sources.appendChild(new Listitem(sourceType.name(), sourceType.name()));
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());

		Row row1 = new Row();
		row1.appendChild(new Label("Date"));
		row1.appendChild(date);

		Row row2 = new Row();
		row2.appendChild(new Label("Status"));
		row2.appendChild(types);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Source"));
		row3.appendChild(sources);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Position"));
		row4.appendChild(positions);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Applicant"));
		row5.appendChild(applicants);

		Row row6 = new Row();
		row6.appendChild(new Label("Referal"));
		row6.appendChild(referals);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}
}