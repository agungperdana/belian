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
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class EmploymentApplicationEditContent extends FormContent
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
	
	private Row row;
	
	public EmploymentApplicationEditContent(Row row)
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
				EmploymentApplicationWindow window = (EmploymentApplicationWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				EmploymentApplication application = service.findOne(RowUtils.string(row, 6));
				if(application != null)
				{
					application.setDate(date.getValue());
					application.setPosition(positionService.findOne(Components.string(positions)));
					application.setApplicant(personService.findOne(Components.string(applicants)));
					application.setSourceType(EmploymentApplication.SourceType.valueOf(Components.string(sources)));
					application.setStatusType(EmploymentApplication.StatusType.valueOf(Components.string(types)));
					
					service.edit(application);
				}
				
				EmploymentApplicationWindow window = (EmploymentApplicationWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		EmploymentApplication application = service.findOne(RowUtils.string(row, 6));
		if(application != null)
		{
			for(EmploymentApplication.StatusType statusType:StatusType.values())
			{
				Listitem listitem = new Listitem(statusType.name(), statusType.name());
				types.appendChild(listitem);
				if(statusType.equals(application.getStatusType()))
					types.setSelectedItem(listitem);
			}
			
			for(SourceType sourceType:SourceType.values())
			{	
				Listitem listitem = new Listitem(sourceType.name(), sourceType.name());
				sources.appendChild(listitem);
				if(sourceType.equals(application.getSourceType()))
					sources.setSelectedItem(listitem);
			}
			
			positions.appendChild(new Listitem(application.getPosition().getLabel(), application.getPosition().getValue()));
			applicants.appendChild(new Listitem(application.getApplicant().getLabel(), application.getApplicant().getValue()));
			
			if(application.getReferal() != null)
			{
				referals.appendChild(new Listitem(application.getReferal().getLabel(),application.getReferal().getValue()));
				Components.setDefault(referals);
			}
			
			Components.setDefault(positions);
			Components.setDefault(applicants);
			
			date.setValue(application.getDate());
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
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
}
