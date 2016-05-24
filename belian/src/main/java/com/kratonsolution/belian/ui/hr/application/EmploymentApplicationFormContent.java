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

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.hr.dm.EmploymentApplication;
import com.kratonsolution.belian.hr.dm.EmploymentApplicationSourceType;
import com.kratonsolution.belian.hr.dm.EmploymentApplicationStatusType;
import com.kratonsolution.belian.hr.svc.EmploymentApplicationService;
import com.kratonsolution.belian.hr.svc.PositionService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.PersonBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
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

	private PersonBox applicant = new PersonBox(true);
	
	private PersonBox referals = new PersonBox(false);

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
				Flow.next(getParent(), new EmploymentApplicationGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				EmploymentApplication application = new EmploymentApplication();
				application.setDate(DateTimes.sql(date.getValue()));
				application.setPosition(positionService.findOne(Components.string(positions)));
				application.setSourceType(EmploymentApplicationSourceType.valueOf(Components.string(sources)));
				application.setStatusType(EmploymentApplicationStatusType.valueOf(Components.string(types)));
				application.setApplicant(applicant.getPerson());
				application.setReferal(referals.getPerson());
				
				service.add(application);
				
				Flow.next(getParent(), new EmploymentApplicationGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		for(EmploymentApplicationStatusType statusType:EmploymentApplicationStatusType.values())
			types.appendChild(new Listitem(statusType.name(), statusType.name()));
		
		for(EmploymentApplicationSourceType sourceType:EmploymentApplicationSourceType.values())
			sources.appendChild(new Listitem(sourceType.name(), sourceType.name()));
		
		Components.setDefault(types);
		Components.setDefault(sources);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
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
		row5.appendChild(applicant);

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
