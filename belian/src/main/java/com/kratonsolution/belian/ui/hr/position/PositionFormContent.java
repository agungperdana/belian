/**
 * 
 */
package com.kratonsolution.belian.ui.hr.position;

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

import com.kratonsolution.belian.accounting.svc.BudgetItemService;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.hr.dm.EmploymentStatus;
import com.kratonsolution.belian.hr.dm.Position;
import com.kratonsolution.belian.hr.dm.PositionStatus;
import com.kratonsolution.belian.hr.dm.SalaryStatus;
import com.kratonsolution.belian.hr.dm.WorktimeStatus;
import com.kratonsolution.belian.hr.svc.PositionService;
import com.kratonsolution.belian.hr.svc.PositionTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PositionFormContent extends FormContent
{	
	private PositionService service = Springs.get(PositionService.class);
	
	private BudgetItemService budgetItemService = Springs.get(BudgetItemService.class);
	
	private PositionTypeService positionTypeService = Springs.get(PositionTypeService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private Datebox actualStart = Components.datebox();
	
	private Datebox actualEnd = Components.datebox();
	
	private Listbox worktimes = Components.newSelect();
	
	private Listbox employmentstatuses = Components.newSelect();
	
	private Listbox salarys = Components.newSelect();
	
	private Listbox positionStatusTypes = Components.newSelect();
	
	private Listbox budgetItems = Components.newSelect(budgetItemService.findAllByOwner(),false);
		
	private Listbox positionTypes = Components.newSelect(positionTypeService.findAll(),true);
	
	private Listbox hirings = Components.newSelect(utils.getOrganizations(),true);
	
	public PositionFormContent()
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
				Flow.next(getParent(), new PositionGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{				
				Position position = new Position();
				position.setActualEnd(DateTimes.sql(actualEnd.getValue()));
				position.setActualStart(DateTimes.sql(actualStart.getValue()));
				position.setBudgetItem(budgetItemService.findOne(Components.string(budgetItems)));
				position.setEnd(DateTimes.sql(end.getValue()));
				position.setSalaryStatus(SalaryStatus.valueOf(Components.string(salarys)));
				position.setStart(DateTimes.sql(start.getValue()));
				position.setOrganization(utils.getOrganization());
				position.setEmploymentStatus(EmploymentStatus.valueOf(Components.string(employmentstatuses)));
				position.setType(positionTypeService.findOne(Components.string(positionTypes)));
				position.setWorktimeStatus(WorktimeStatus.valueOf(Components.string(worktimes)));
				position.setPositionStatusType(PositionStatus.valueOf(Components.string(positionStatusTypes)));
				
				service.add(position);
				
				Flow.next(getParent(), new PositionGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		for(WorktimeStatus status:WorktimeStatus.values())
			worktimes.appendChild(new Listitem(status.name(), status.name()));
		
		for(EmploymentStatus status:EmploymentStatus.values())
			employmentstatuses.appendChild(new Listitem(status.name(), status.name()));
		
		for(SalaryStatus status:SalaryStatus.values())
			salarys.appendChild(new Listitem(status.name(), status.name()));
		
		for(PositionStatus status:PositionStatus.values())
		{
			Listitem listitem = new Listitem(status.name(), status.name());
			positionStatusTypes.appendChild(listitem);
			
			if(status.equals(PositionStatus.Planned))
				positionStatusTypes.setSelectedItem(listitem);
		}
		
		Components.setDefault(hirings);
		Components.setDefault(worktimes);
		Components.setDefault(employmentstatuses);
		Components.setDefault(salarys);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"135px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Start Date"));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label("End Date"));
		row2.appendChild(end);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Actual Start Date"));
		row3.appendChild(actualStart);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Actual End Date"));
		row4.appendChild(actualEnd);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Worktime Type"));
		row5.appendChild(worktimes);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Employment Type"));
		row6.appendChild(employmentstatuses);
		
		Row row7 = new Row();
		row7.appendChild(new Label("Budget Item"));
		row7.appendChild(budgetItems);
		
		Row row8 = new Row();
		row8.appendChild(new Label("Position Type"));
		row8.appendChild(positionTypes);
		
		Row row9 = new Row();
		row9.appendChild(new Label("Hiring Organization"));
		row9.appendChild(hirings);
		
		Row row10 = new Row();
		row10.appendChild(new Label("Position Status Type"));
		row10.appendChild(positionStatusTypes);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
		rows.appendChild(row7);
		rows.appendChild(row8);
		rows.appendChild(row9);
		rows.appendChild(row10);
	}
}
