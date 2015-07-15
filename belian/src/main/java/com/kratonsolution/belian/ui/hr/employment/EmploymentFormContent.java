/**
 * 
 */
package com.kratonsolution.belian.ui.hr.employment;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.kratonsolution.belian.accounting.dm.BudgetItem;
import com.kratonsolution.belian.accounting.svc.BudgetItemService;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.hr.dm.Position;
import com.kratonsolution.belian.hr.dm.Position.PositionStatusType;
import com.kratonsolution.belian.hr.svc.PositionService;
import com.kratonsolution.belian.hr.svc.PositionTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class EmploymentFormContent extends FormContent
{	
	private PositionService service = Springs.get(PositionService.class);
	
	private BudgetItemService budgetItemService = Springs.get(BudgetItemService.class);
	
	private PositionTypeService positionTypeService = Springs.get(PositionTypeService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
		
	private Listbox positionStatusTypes = Components.newSelect();
	
	private Listbox budgetItems = Components.newSelect();
	
	private Listbox positionTypes = Components.newSelect(positionTypeService.findAll(),true);
	
	private Listbox owners = Components.newSelect(organizationService.findAllByRolesTypeName("Internal Organization"), false);
	
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
				if(owners.getSelectedIndex() < 0)
					throw new WrongValueException(owners,"Document Owner cannot be empty");
				
				if(budgetItems.getSelectedIndex() < 0)
					throw new WrongValueException(budgetItems,"Budget Item cannot be empty");
				
				Position position = new Position();
				position.setBudgetItem(budgetItemService.findOne(Components.string(budgetItems)));
				position.setOwner(organizationService.findOne(Components.string(owners)));
				position.setEnd(end.getValue());
				position.setStart(start.getValue());
				position.setType(positionTypeService.findOne(Components.string(positionTypes)));
				position.setPositionStatusType(PositionStatusType.valueOf(Components.string(positionStatusTypes)));
				
				service.add(position);
				
				EmploymentWindow window = (EmploymentWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{

		owners.addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				budgetItems.getChildren().clear();
				
				for(BudgetItem item:budgetItemService.findAllByOwner(Components.string(owners)))
					budgetItems.appendChild(new Listitem(item.getLabel(), item.getValue()));
			
				Components.setDefault(budgetItems);
			}
		});
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
//		Row row1 = new Row();
//		row1.appendChild(new Label("Start Date"));
//		row1.appendChild(start);
//		row1.appendChild(new Label("End Date"));
//		row1.appendChild(end);
//		
//		Row row2 = new Row();
//		row2.appendChild(new Label("Actual Start Date"));
//		row2.appendChild(actualStart);
//		row2.appendChild(new Label("Actual End Date"));
//		row2.appendChild(actualEnd);
//		
//		Row row3 = new Row();
//		row3.appendChild(new Label("Worktime Type"));
//		row3.appendChild(worktimes);
//		row3.appendChild(new Label("Employment Type"));
//		row3.appendChild(employmentstatuses);
//		
//		Row row4 = new Row();
//		row4.appendChild(new Label("Salary Type"));
//		row4.appendChild(salarys);
//		row4.appendChild(new Label("Document Owner"));
//		row4.appendChild(owners);
//		
//		Row row5 = new Row();
//		row5.appendChild(new Label("Budget Item"));
//		row5.appendChild(budgetItems);
//		row5.appendChild(new Label("Position Type"));
//		row5.appendChild(positionTypes);
//		
//		Row row6 = new Row();
//		row6.appendChild(new Label("Position Status Type"));
//		row6.appendChild(positionStatusTypes);
//		
//		rows.appendChild(row1);
//		rows.appendChild(row2);
//		rows.appendChild(row3);
//		rows.appendChild(row4);
//		rows.appendChild(row5);
//		rows.appendChild(row6);
	}
}
