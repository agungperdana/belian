/**
 * 
 */
package com.kratonsolution.belian.ui.hr.employment;

import java.util.Iterator;
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
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

import com.kratonsolution.belian.accounting.svc.BudgetItemService;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.hr.dm.EmploymentStatus;
import com.kratonsolution.belian.hr.dm.Position;
import com.kratonsolution.belian.hr.dm.PositionFulfillment;
import com.kratonsolution.belian.hr.dm.PositionReportingStructure;
import com.kratonsolution.belian.hr.dm.PositionResponsibility;
import com.kratonsolution.belian.hr.dm.PositionStatus;
import com.kratonsolution.belian.hr.dm.PositionType;
import com.kratonsolution.belian.hr.dm.SalaryStatus;
import com.kratonsolution.belian.hr.dm.WorktimeStatus;
import com.kratonsolution.belian.hr.svc.PositionReportingStructureService;
import com.kratonsolution.belian.hr.svc.PositionService;
import com.kratonsolution.belian.hr.svc.PositionTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class EmploymentEditContent extends FormContent
{	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private PositionService service = Springs.get(PositionService.class);

	private BudgetItemService budgetItemService = Springs.get(BudgetItemService.class);

	private PositionTypeService positionTypeService = Springs.get(PositionTypeService.class);
	
	private OrganizationService organizationService = Springs.get(OrganizationService.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private PositionReportingStructureService reportingStructureService = Springs.get(PositionReportingStructureService.class);

	private Datebox start = Components.currentDatebox();

	private Datebox end = Components.datebox();

	private Datebox actualStart = Components.datebox();

	private Datebox actualEnd = Components.datebox();

	private Listbox worktimes = Components.newSelect();

	private Listbox employmentstatuses = Components.newSelect();

	private Listbox salaryStatus = Components.newSelect();

	private Listbox budgetItems = Components.newSelect();

	private Listbox positionTypes = Components.newSelect();
	
	private Listbox positionStatusTypes = Components.newSelect();
	
	private Listbox owners = Components.newSelect(utils.getOrganization());

	private Row row;
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid responsibilitys = new Grid();
	
	private Grid fulfillments = new Grid();
	
	private Grid reportings = new Grid();

	public EmploymentEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
		
		appendChild(tabbox);
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab("Responsibilitys"));
		tabbox.getTabs().appendChild(new Tab("Fulfillment"));
		tabbox.getTabs().appendChild(new Tab("Reporting Structure"));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		responsibilitys.appendChild(new Rows());
		responsibilitys.appendChild(new Columns());
		fulfillments.appendChild(new Rows());
		fulfillments.appendChild(new Columns());
		reportings.appendChild(new Rows());
		reportings.appendChild(new Columns());
	
		initResponsibilitys();
		initFulfillment();
		initReporting();
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
					if(owners.getSelectedIndex() < 0)
						throw new WrongValueException(owners,"Document Owner cannot be empty");
					
					if(budgetItems.getSelectedIndex() < 0)
						throw new WrongValueException(budgetItems,"Budget Item cannot be empty");
					
					position.setActualEnd(actualEnd.getValue());
					position.setActualStart(actualStart.getValue());
					position.setBudgetItem(budgetItemService.findOne(Components.string(budgetItems)));
					position.setEnd(end.getValue());
					position.setOrganization(utils.getOrganization());
					position.setSalaryStatus(SalaryStatus.valueOf(Components.string(salaryStatus)));
					position.setStart(start.getValue());
					position.setEmploymentStatus(EmploymentStatus.valueOf(Components.string(employmentstatuses)));
					position.setType(positionTypeService.findOne(Components.string(positionTypes)));
					position.setWorktimeStatus(WorktimeStatus.valueOf(Components.string(worktimes)));
					position.setPositionStatusType(PositionStatus.valueOf(Components.string(positionStatusTypes)));
					position.getResponsibilitys().clear();
					position.getFulfillments().clear();
					position.getReportings().clear();
					
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
					
					for(Component component:fulfillments.getRows().getChildren())
					{
						Row row = (Row) component;
						
						PositionFulfillment fulfillment = new PositionFulfillment();
						fulfillment.setDescription(RowUtils.string(row, 4));
						fulfillment.setEmployee(personService.findOne(RowUtils.string(row, 3)));
						fulfillment.setEnd(RowUtils.date(row, 2));
						fulfillment.setPosition(position);
						fulfillment.setStart(RowUtils.date(row, 1));
						fulfillment.setId(RowUtils.string(row, 5));
						
						position.getFulfillments().add(fulfillment);
					}
					
					for(Component component:reportings.getRows().getChildren())
					{
						Row row = (Row)component;
						
						PositionReportingStructure report = new PositionReportingStructure();
						report.setId(RowUtils.string(row, 5));
						report.setDescription(RowUtils.string(row, 4));
						report.setEnd(RowUtils.date(row, 2));
						report.setPrimary(false);
						report.setReportTo(service.findOne(RowUtils.string(row, 3)));
						report.setStart(RowUtils.date(row, 1));
						report.setPosition(position);
						
						position.getReportings().add(report);
					}
					
					service.edit(position);
				}
				
				EmploymentWindow window = (EmploymentWindow)getParent();
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
			employmentstatuses.appendChild(listitem);
			if(position.getEmploymentStatus().equals(status))
				employmentstatuses.setSelectedItem(listitem);
		}
		
		for(SalaryStatus status:SalaryStatus.values())
		{
			Listitem listitem = new Listitem(status.name(), status.name());
			salaryStatus.appendChild(listitem);
			if(position.getSalaryStatus().equals(status))
				salaryStatus.setSelectedItem(listitem);
		}
		
		for(PositionStatus status:PositionStatus.values())
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
		
		start.setValue(position.getStart());
		end.setValue(position.getEnd());
		actualStart.setValue(position.getActualStart());
		actualEnd.setValue(position.getActualEnd());
		
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
		
		Row row4 = new Row();
		row4.appendChild(new Label("Salary Type"));
		row4.appendChild(salaryStatus);
		row4.appendChild(new Label("Document Owner"));
		row4.appendChild(owners);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Budget Item"));
		row5.appendChild(budgetItems);
		row5.appendChild(new Label("Position Type"));
		row5.appendChild(positionTypes);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Position Status Type"));
		row6.appendChild(positionStatusTypes);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
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
	
	private void initFulfillment()
	{
		Position position = service.findOne(RowUtils.string(row, 9));
		
		NRCToolbar toolbar = new NRCToolbar();
		
		fulfillments.getColumns().appendChild(new Column(null,null,"25px"));
		fulfillments.getColumns().appendChild(new Column("Start Date",null,"125px"));
		fulfillments.getColumns().appendChild(new Column("End Date",null,"125px"));
		fulfillments.getColumns().appendChild(new Column("Person",null,"175px"));
		fulfillments.getColumns().appendChild(new Column("Description",null,null));
		fulfillments.getColumns().appendChild(new Column(null,null,"1px"));
		fulfillments.getColumns().getChildren().get(5).setVisible(false);
		fulfillments.setSpan("4");
		
		for(PositionFulfillment fulfillment:position.getFulfillments())
		{
			Row row = new Row();
			row.appendChild(Components.checkbox(false));
			row.appendChild(Components.mandatoryDatebox(fulfillment.getStart()));
			row.appendChild(Components.fullSpanDatebox(fulfillment.getEnd()));
			row.appendChild(Components.fullSpanSelect(fulfillment.getEmployee()));
			row.appendChild(Components.mandatoryTextBox(fulfillment.getDescription()));
			row.appendChild(new Label(fulfillment.getId()));
			
			fulfillments.getRows().appendChild(row);
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
				row.appendChild(Components.fullSpanSelect(personService.findAllByRolesType("Employee Prospect"),true));
				row.appendChild(Components.mandatoryTextBox());
				row.appendChild(new Label(UUID.randomUUID().toString()));
				
				fulfillments.getRows().appendChild(row);
			}
		});
		
		toolbar.getRemove().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Iterator<Component> iterator = fulfillments.getRows().getChildren().iterator();
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
				fulfillments.getRows().getChildren().clear();
			}
		});
		
		tabbox.getTabpanels().getChildren().get(1).appendChild(toolbar);
		tabbox.getTabpanels().getChildren().get(1).appendChild(fulfillments);
	}
	
	private void initReporting()
	{
		Position position = service.findOne(RowUtils.string(row, 9));
		
		NRCToolbar toolbar = new NRCToolbar();
		
		reportings.getColumns().appendChild(new Column(null,null,"25px"));
		reportings.getColumns().appendChild(new Column("Start Date",null,"125px"));
		reportings.getColumns().appendChild(new Column("End Date",null,"125px"));
		reportings.getColumns().appendChild(new Column("Position",null,"175px"));
		reportings.getColumns().appendChild(new Column("Description",null,null));
		reportings.getColumns().appendChild(new Column(null,null,"1px"));
		reportings.getColumns().getChildren().get(5).setVisible(false);
		reportings.setSpan("4");
		
		for(PositionReportingStructure report:position.getReportings())
		{
			Row row = new Row();
			row.appendChild(Components.checkbox(false));
			row.appendChild(Components.mandatoryDatebox(report.getStart()));
			row.appendChild(Components.fullSpanDatebox(report.getEnd()));
			row.appendChild(Components.fullSpanSelect(report.getReportTo()));
			row.appendChild(Components.mandatoryTextBox(report.getDescription()));
			row.appendChild(new Label(report.getId()));
			
			reportings.getRows().appendChild(row);
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
				row.appendChild(Components.fullSpanSelect(service.findAllNotEqual(position.getId()),true));
				row.appendChild(Components.mandatoryTextBox());
				row.appendChild(new Label(UUID.randomUUID().toString()));
				
				reportings.getRows().appendChild(row);
			}
		});
		
		toolbar.getRemove().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Iterator<Component> iterator = reportings.getRows().getChildren().iterator();
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
				reportings.getRows().getChildren().clear();
			}
		});
		
		tabbox.getTabpanels().getChildren().get(2).appendChild(toolbar);
		tabbox.getTabpanels().getChildren().get(2).appendChild(reportings);
	}
	
}
