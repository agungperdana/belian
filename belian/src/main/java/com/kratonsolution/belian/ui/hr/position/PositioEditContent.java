/**
 * 
 */
package com.kratonsolution.belian.ui.hr.position;

import java.util.Iterator;
import java.util.UUID;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

import com.kratonsolution.belian.accounting.dm.BudgetItem;
import com.kratonsolution.belian.accounting.svc.BudgetItemService;
import com.kratonsolution.belian.hr.dm.Position;
import com.kratonsolution.belian.hr.dm.Position.EmploymentStatus;
import com.kratonsolution.belian.hr.dm.Position.PositionStatusType;
import com.kratonsolution.belian.hr.dm.Position.SalaryStatus;
import com.kratonsolution.belian.hr.dm.Position.WorktimeStatus;
import com.kratonsolution.belian.hr.dm.PositionResponsibility;
import com.kratonsolution.belian.hr.dm.PositionType;
import com.kratonsolution.belian.hr.svc.PositionService;
import com.kratonsolution.belian.hr.svc.PositionTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class PositioEditContent extends FormContent
{	
	private PositionService service = Springs.get(PositionService.class);

	private BudgetItemService budgetItemService = Springs.get(BudgetItemService.class);

	private PositionTypeService positionTypeService = Springs.get(PositionTypeService.class);

	private Datebox start = Components.currentDatebox();

	private Datebox end = Components.datebox();

	private Datebox actualStart = Components.datebox();

	private Datebox actualEnd = Components.datebox();

	private Listbox worktimes = Components.newSelect();

	private Listbox statuses = Components.newSelect();

	private Listbox salarys = Components.newSelect();

	private Listbox budgetItems = Components.newSelect();

	private Listbox positionTypes = Components.newSelect();
	
	private Listbox positionStatusTypes = Components.newSelect();

	private Row row;
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid responsibilitys = new Grid();

	public PositioEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
		
		appendChild(tabbox);
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab("Responsibilitys"));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		responsibilitys.appendChild(new Rows());
		responsibilitys.appendChild(new Columns());
	
		initResponsibilitys();
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
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{

				Position position = service.findOne(RowUtils.string(row, 9));
				if(position != null)
				{
					position.setActualEnd(actualEnd.getValue());
					position.setActualStart(actualStart.getValue());
					position.setBudgetItem(budgetItemService.findOne(Components.string(budgetItems)));
					position.setEnd(end.getValue());
					position.setSalaryStatus(SalaryStatus.valueOf(Components.string(salarys)));
					position.setStart(start.getValue());
					position.setEmploymentStatus(EmploymentStatus.valueOf(Components.string(statuses)));
					position.setType(positionTypeService.findOne(Components.string(positionTypes)));
					position.setWorktimeStatus(WorktimeStatus.valueOf(Components.string(worktimes)));
					position.setPositionStatusType(PositionStatusType.valueOf(Components.string(positionStatusTypes)));
					position.getResponsibilitys().clear();
					
					service.edit(position);
				
					Iterator<Component> iterator = responsibilitys.getRows().getChildren().iterator();
					while (iterator.hasNext())
					{
						Row row = (Row) iterator.next();
						
						PositionResponsibility responsibility = new PositionResponsibility();
						responsibility.setDescription(RowUtils.string(row, 3));
						responsibility.setEnd(RowUtils.date(row, 2));
						responsibility.setStart(RowUtils.date(row, 1));
						responsibility.setId(RowUtils.string(row, 4));
						responsibility.setPosition(position);
						
						position.getResponsibilitys().add(responsibility);
					}
					
					service.edit(position);
				}
				
				PositionWindow window = (PositionWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		Position position = service.findOne(RowUtils.string(row, 9));
		
		for(WorktimeStatus status:WorktimeStatus.values())
		{
			Listitem listitem = new Listitem(status.name(), status.name());
			worktimes.appendChild(listitem);
			if(position.getWorktimeStatus().equals(status))
				worktimes.setSelectedItem(listitem);
		}
		
		for(EmploymentStatus status:EmploymentStatus.values())
		{
			Listitem listitem = new Listitem(status.name(), status.name());
			statuses.appendChild(listitem);
			if(position.getEmploymentStatus().equals(status))
				statuses.setSelectedItem(listitem);
		}
		
		for(SalaryStatus status:SalaryStatus.values())
		{
			Listitem listitem = new Listitem(status.name(), status.name());
			salarys.appendChild(listitem);
			if(position.getSalaryStatus().equals(status))
				salarys.setSelectedItem(listitem);
		}
		
		for(PositionStatusType status:PositionStatusType.values())
		{
			Listitem listitem = new Listitem(status.name(), status.name());
			positionStatusTypes.appendChild(listitem);
			if(status.equals(position.getPositionStatusType()))
				positionStatusTypes.setSelectedItem(listitem);
		}

		for(PositionType type:positionTypeService.findAll())
		{
			Listitem listitem = new Listitem(type.getTitle(),type.getId());
			positionTypes.appendChild(listitem);
			if(type.getId().equals(position.getType().getId()))
				positionTypes.setSelectedItem(listitem);
		}
		
		for(BudgetItem item:budgetItemService.findAll())
		{
			Listitem listitem = new Listitem(item.getPurpose(),item.getId());
			budgetItems.appendChild(listitem);
			
			
			if(position.getBudgetItem() != null && item.getId().equals(position.getBudgetItem().getId()))
				budgetItems.setSelectedItem(listitem);
		}
		
		start.setValue(position.getStart());
		end.setValue(position.getEnd());
		actualStart.setValue(position.getActualStart());
		actualEnd.setValue(position.getActualEnd());
		
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
		row3.appendChild(new Label("Actual Start Date"));
		row3.appendChild(actualStart);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Actual End Date"));
		row4.appendChild(actualEnd);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Work Time"));
		row5.appendChild(worktimes);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Status"));
		row6.appendChild(statuses);
		
		Row row7 = new Row();
		row7.appendChild(new Label("Salary Type"));
		row7.appendChild(salarys);
		
		Row row8 = new Row();
		row8.appendChild(new Label("Budget Item"));
		row8.appendChild(budgetItems);
		
		Row row9 = new Row();
		row9.appendChild(new Label("Position Type"));
		row9.appendChild(positionTypes);
		
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
	
	private void initResponsibilitys()
	{
		Position position = service.findOne(RowUtils.string(row, 9));
		
		NRCToolbar toolbar = new NRCToolbar();
		
		responsibilitys.getColumns().appendChild(new Column(null,null,"25px"));
		responsibilitys.getColumns().appendChild(new Column("Start Date",null,"125px"));
		responsibilitys.getColumns().appendChild(new Column("End Date",null,"125px"));
		responsibilitys.getColumns().appendChild(new Column("Description",null,null));
		responsibilitys.getColumns().appendChild(new Column(null,null,"1px"));
		responsibilitys.getColumns().getChildren().get(4).setVisible(false);
		responsibilitys.setSpan("3");
		
		for(PositionResponsibility responsibility:position.getResponsibilitys())
		{
			Row row = new Row();
			row.appendChild(Components.checkbox(false));
			row.appendChild(Components.mandatoryDatebox(responsibility.getStart()));
			row.appendChild(Components.fullSpanDatebox(responsibility.getEnd()));
			row.appendChild(Components.mandatoryTextBox(responsibility.getDescription()));
			row.appendChild(new Label(responsibility.getId()));
			
			responsibilitys.getRows().appendChild(row);
		}
		
		toolbar.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(Components.mandatoryTextBox());
				row.appendChild(new Label(UUID.randomUUID().toString()));
				
				responsibilitys.getRows().appendChild(row);
			}
		});
		
		toolbar.getRemove().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Iterator<Component> iterator = responsibilitys.getRows().getChildren().iterator();
				while (iterator.hasNext())
				{
					Row row = (Row) iterator.next();
					if(RowUtils.isChecked(row, 0))
						iterator.remove();
				}
			}
		});
		
		toolbar.getClear().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				responsibilitys.getRows().getChildren().clear();
			}
		});
		
		tabbox.getTabpanels().getChildren().get(0).appendChild(toolbar);
		tabbox.getTabpanels().getChildren().get(0).appendChild(responsibilitys);
	}
}
