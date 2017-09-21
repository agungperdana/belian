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
import org.zkoss.zul.Toolbarbutton;

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
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmploymentApplicationEditContent extends FormContent
{	
	private EmploymentApplicationService service = Springs.get(EmploymentApplicationService.class);

	private PersonService personService = Springs.get(PersonService.class);
	
	private PositionService positionService = Springs.get(PositionService.class);
	
	private Datebox date = Components.currentDatebox();

	private Listbox sources = Components.newSelect();

	private Listbox positions = Components.newSelect(positionService.findAll(),true);

	private PersonBox applicant = new PersonBox(false);
	
	private PersonBox referals = new PersonBox(false);
	
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
				Flow.next(getParent(), new EmploymentApplicationGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				EmploymentApplication application = service.findOne(RowUtils.id(row));
				if(application != null)
				{
					application.setDate(DateTimes.sql(date.getValue()));
					application.setPosition(positionService.findOne(Components.string(positions)));
					application.setApplicant(applicant.getPerson());
					application.setReferal(referals.getPerson());
					application.setSourceType(EmploymentApplicationSourceType.valueOf(Components.string(sources)));
					
					service.edit(application);
				}
				
				Flow.next(getParent(), new EmploymentApplicationGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		EmploymentApplication application = service.findOne(RowUtils.id(row));
		if(application != null)
		{
			if(application.getStatusType().equals(EmploymentApplicationStatusType.RECEIVED))
			{
				Toolbarbutton reviewed = new Toolbarbutton(lang.get("label.component.button.review"));
				Toolbarbutton accept = new Toolbarbutton(lang.get("label.component.button.accept"));
				Toolbarbutton reject = new Toolbarbutton(lang.get("label.component.button.reject"));
				
				toolbar.appendChild(reviewed);
				toolbar.appendChild(accept);
				toolbar.appendChild(reject);
				
				accept.addEventListener(Events.ON_CLICK,new EventListener<Event>()
				{
					@Override
					public void onEvent(Event arg0) throws Exception
					{
					}
				});
			}
			else if(application.getStatusType().equals(EmploymentApplicationStatusType.REVIEWED))
			{
				Toolbarbutton accept = new Toolbarbutton(lang.get("label.component.button.accept"));
				Toolbarbutton reject = new Toolbarbutton(lang.get("label.component.button.reject"));
				
				toolbar.appendChild(accept);
				toolbar.appendChild(reject);
			}
			
			for(EmploymentApplicationSourceType sourceType:EmploymentApplicationSourceType.values())
			{	
				Listitem listitem = new Listitem(sourceType.name(), sourceType.name());
				sources.appendChild(listitem);
				if(sourceType.equals(application.getSourceType()))
					sources.setSelectedItem(listitem);
			}

			applicant.setPerson(application.getApplicant());
			referals.setPerson(application.getReferal());
			
			date.setValue(application.getDate());
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"100px"));
			grid.getColumns().appendChild(new Column());

			Row row1 = new Row();
			row1.appendChild(new Label(lang.get("emplapp.grid.column.date")));
			row1.appendChild(date);

			Row row2 = new Row();
			row2.appendChild(new Label(lang.get("emplapp.grid.column.status")));
			row2.appendChild(new Label(application.getStatusType().name()));
			
			Row row3 = new Row();
			row3.appendChild(new Label(lang.get("emplapp.grid.column.source")));
			row3.appendChild(sources);
			
			Row row4 = new Row();
			row4.appendChild(new Label(lang.get("emplapp.grid.column.position")));
			row4.appendChild(positions);
			
			Row row5 = new Row();
			row5.appendChild(new Label(lang.get("emplapp.grid.column.applicant")));
			row5.appendChild(applicant);

			Row row6 = new Row();
			row6.appendChild(new Label(lang.get("emplapp.grid.column.referal")));
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
