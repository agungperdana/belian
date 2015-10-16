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
import com.kratonsolution.belian.general.dm.OrganizationUnit;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.OrganizationUnitService;
import com.kratonsolution.belian.hr.dm.Position;
import com.kratonsolution.belian.hr.dm.Position.EmploymentStatus;
import com.kratonsolution.belian.hr.dm.Position.PositionStatusType;
import com.kratonsolution.belian.hr.dm.Position.SalaryStatus;
import com.kratonsolution.belian.hr.dm.Position.WorktimeStatus;
import com.kratonsolution.belian.hr.svc.PositionService;
import com.kratonsolution.belian.hr.svc.PositionTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class PositionFormContent extends FormContent
{	
	private PositionService service = Springs.get(PositionService.class);
	
	private BudgetItemService budgetItemService = Springs.get(BudgetItemService.class);
	
	private PositionTypeService positionTypeService = Springs.get(PositionTypeService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private OrganizationUnitService unitService = Springs.get(OrganizationUnitService.class);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private Datebox actualStart = Components.datebox();
	
	private Datebox actualEnd = Components.datebox();
	
	private Listbox worktimes = Components.fullSpanSelect();
	
	private Listbox employmentstatuses = Components.fullSpanSelect();
	
	private Listbox salarys = Components.fullSpanSelect();
	
	private Listbox positionStatusTypes = Components.fullSpanSelect();
	
	private Listbox budgetItems = Components.fullSpanSelect();
		
	private Listbox positionTypes = Components.fullSpanSelect(positionTypeService.findAll(),true);
	
	private Listbox hirings = Components.fullSpanSelect();
	
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
				PositionWindow window = (PositionWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{				
				Position position = new Position();
				position.setActualEnd(actualEnd.getValue());
				position.setActualStart(actualStart.getValue());
				position.setBudgetItem(budgetItemService.findOne(Components.string(budgetItems)));
				position.setEnd(end.getValue());
				position.setSalaryStatus(SalaryStatus.valueOf(Components.string(salarys)));
				position.setStart(start.getValue());
				position.setHiringOrganization(organizationService.findOne(Components.string(hirings)));
				position.setEmploymentStatus(EmploymentStatus.valueOf(Components.string(employmentstatuses)));
				position.setType(positionTypeService.findOne(Components.string(positionTypes)));
				position.setWorktimeStatus(WorktimeStatus.valueOf(Components.string(worktimes)));
				position.setPositionStatusType(PositionStatusType.valueOf(Components.string(positionStatusTypes)));
				
				service.add(position);
				
				PositionWindow window = (PositionWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
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
		
		for(PositionStatusType status:PositionStatusType.values())
		{
			Listitem listitem = new Listitem(status.name(), status.name());
			positionStatusTypes.appendChild(listitem);
			
			if(status.equals(PositionStatusType.Planned))
				positionStatusTypes.setSelectedItem(listitem);
		}
		
		for(OrganizationUnit unit:unitService.findAll())
			hirings.appendChild(new Listitem(unit.getParty().getLabel(), unit.getParty().getValue()));
		
		Components.setDefault(hirings);
		Components.setDefault(worktimes);
		Components.setDefault(employmentstatuses);
		Components.setDefault(salarys);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Start Date"));
		row1.appendChild(start);
		row1.appendChild(new Label("End Date"));
		row1.appendChild(end);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Actual Start Date"));
		row2.appendChild(actualStart);
		row2.appendChild(new Label("Actual End Date"));
		row2.appendChild(actualEnd);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Worktime Type"));
		row3.appendChild(worktimes);
		row3.appendChild(new Label("Employment Type"));
		row3.appendChild(employmentstatuses);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Budget Item"));
		row5.appendChild(budgetItems);
		row5.appendChild(new Label("Position Type"));
		row5.appendChild(positionTypes);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Hiring Organization"));
		row6.appendChild(hirings);
		row6.appendChild(new Label("Position Status Type"));
		row6.appendChild(positionStatusTypes);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}
}
