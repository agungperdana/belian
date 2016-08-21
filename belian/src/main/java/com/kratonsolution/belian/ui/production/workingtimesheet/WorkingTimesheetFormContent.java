/**
 * 
 */
package com.kratonsolution.belian.ui.production.workingtimesheet;

import java.util.UUID;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.effort.dm.TimeEntry;
import com.kratonsolution.belian.effort.dm.Timesheet;
import com.kratonsolution.belian.production.svc.WorkingTimesheetService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.EmployeeBox;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkingTimesheetFormContent extends FormContent
{	
	private WorkingTimesheetService service = Springs.get(WorkingTimesheetService.class);
	
	private OrganizationList companys = new OrganizationList();
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private EmployeeBox employees = new EmployeeBox(false);
	
	private Grid entrys = new Grid();
	
	public WorkingTimesheetFormContent()
	{
		super();
		initToolbar();
		initForm();
		initEntrys();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(),new WorkingTimesheetGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(companys.getOrganization() == null)
					throw new WrongValueException(companys,lang.get("message.field.empty"));
				
				if(employees.getEmployee() == null)
					throw new WrongValueException(employees,lang.get("message.field.empty"));

				Timesheet timesheet = new Timesheet();
				timesheet.setWorker(employees.getEmployee());
				timesheet.setEnd(DateTimes.sql(end.getValue()));
				timesheet.setOrganization(companys.getOrganization());
				timesheet.setStart(DateTimes.sql(start.getValue()));
				
				for(Component com:entrys.getRows().getChildren())
				{
					Row ent = (Row)com;
					
					TimeEntry entry = new TimeEntry();
					entry.setStart(null);
					entry.setEnd(null);
					entry.setHour(null);
					entry.setComment(RowUtils.string(ent, 4));
					entry.setTimesheet(timesheet);
					
					timesheet.getTimeEntrys().add(entry);
				}
				
				service.add(timesheet);
				
				Flow.next(getParent(),new WorkingTimesheetGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("workingtimesheet.grid.column.company")));
		row1.appendChild(companys);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("workingtimesheet.grid.column.start")));
		row2.appendChild(start);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("workingtimesheet.grid.column.end")));
		row3.appendChild(end);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("workingtimesheet.grid.column.employee")));
		row4.appendChild(employees);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
	
	private void initEntrys()
	{
		NRCToolbar nrc = new NRCToolbar(entrys);
		
		entrys.setWidth("100%");
		entrys.setEmptyMessage(lang.get("message.grid.empty"));
		entrys.appendChild(new Columns());
		entrys.appendChild(new Rows());
		entrys.getColumns().appendChild(new Column(null,null,"25px"));
		entrys.getColumns().appendChild(new Column(lang.get("workingtimesheet.grid.column.date"),null,"120px"));
		entrys.getColumns().appendChild(new Column(lang.get("workingtimesheet.grid.column.timestart"),null,"110px"));
		entrys.getColumns().appendChild(new Column(lang.get("workingtimesheet.grid.column.timeend"),null,"110px"));
		entrys.getColumns().appendChild(new Column(lang.get("workingtimesheet.grid.column.note"),null,"100px"));
		entrys.getColumns().appendChild(new Column());
		entrys.getColumns().getLastChild().setVisible(false);
		entrys.setSpan("4");
		
		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(Components.fullspanTimebox(DateTimes.currentTime()));
				row.appendChild(Components.fullspanTimebox(null));
				row.appendChild(Components.textBox(null));
				row.appendChild(Components.label(UUID.randomUUID().toString()));
				
				entrys.getRows().appendChild(row);
			}
		});
		
		appendChild(nrc);
		appendChild(entrys);
	}
}
