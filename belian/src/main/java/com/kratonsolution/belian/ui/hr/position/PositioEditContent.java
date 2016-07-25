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

import com.kratonsolution.belian.accounting.svc.BudgetItemService;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.hr.dm.EmploymentStatus;
import com.kratonsolution.belian.hr.dm.Position;
import com.kratonsolution.belian.hr.dm.PositionFulfillment;
import com.kratonsolution.belian.hr.dm.PositionReportingStructure;
import com.kratonsolution.belian.hr.dm.PositionResponsibility;
import com.kratonsolution.belian.hr.dm.PositionStatus;
import com.kratonsolution.belian.hr.dm.SalaryStatus;
import com.kratonsolution.belian.hr.dm.WorktimeStatus;
import com.kratonsolution.belian.hr.svc.EmploymentService;
import com.kratonsolution.belian.hr.svc.PositionService;
import com.kratonsolution.belian.hr.svc.PositionTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PositioEditContent extends FormContent
{	
	private PositionService service = Springs.get(PositionService.class);

	private EmploymentService employmentService = Springs.get(EmploymentService.class);
	
	private PersonService personService = Springs.get(PersonService.class);

	private BudgetItemService budgetItemService = Springs.get(BudgetItemService.class);
	
	private PositionTypeService positionTypeService = Springs.get(PositionTypeService.class);

	private OrganizationService organizationService = Springs.get(OrganizationService.class);

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

	private OrganizationList companys = new OrganizationList();

	private Row row;

	private Tabbox tabbox = new Tabbox();

	private Grid responsibilitys = new Grid();

	private Grid fulfillments = new Grid();

	private Grid reportings = new Grid();

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
				Flow.next(getParent(), new PositionGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{

				Position position = service.findOne(RowUtils.id(row));
				if(position != null)
				{
					position.setActualEnd(DateTimes.sql(actualEnd.getValue()));
					position.setActualStart(DateTimes.sql(actualStart.getValue()));
					position.setEnd(DateTimes.sql(end.getValue()));
					position.setOrganization(companys.getOrganization());
					position.setSalaryStatus(SalaryStatus.valueOf(Components.string(salarys)));
					position.setStart(DateTimes.sql(start.getValue()));
					position.setEmploymentStatus(EmploymentStatus.valueOf(Components.string(employmentstatuses)));
					position.setType(positionTypeService.findOne(Components.string(positionTypes)));
					position.setWorktimeStatus(WorktimeStatus.valueOf(Components.string(worktimes)));
					position.setPositionStatusType(PositionStatus.valueOf(Components.string(positionStatusTypes)));
					position.setBudgetItem(budgetItemService.findOne(Components.string(budgetItems)));
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
						responsibility.setEnd(RowUtils.sql(row, 2));
						responsibility.setStart(RowUtils.sql(row, 1));
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
						fulfillment.setEnd(RowUtils.sql(row, 2));
						fulfillment.setPosition(position);
						fulfillment.setStart(RowUtils.sql(row, 1));
						fulfillment.setId(RowUtils.string(row, 5));

						position.getFulfillments().add(fulfillment);
					}

					for(Component component:reportings.getRows().getChildren())
					{
						Row row = (Row)component;

						PositionReportingStructure report = new PositionReportingStructure();
						report.setId(RowUtils.string(row, 5));
						report.setDescription(RowUtils.string(row, 4));
						report.setEnd(RowUtils.sql(row, 2));
						report.setPrimary(false);
						report.setReportTo(service.findOne(RowUtils.string(row, 3)));
						report.setStart(RowUtils.sql(row, 1));
						report.setPosition(position);

						position.getReportings().add(report);
					}

					service.edit(position);
				}

				Flow.next(getParent(), new PositionGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		Position position = service.findOne(RowUtils.id(row));
		if(position != null)
		{
			companys.setOrganization(position.getOrganization());
			start.setValue(position.getStart());
			end.setValue(position.getEnd());
			actualStart.setValue(position.getActualStart());
			actualEnd.setValue(position.getActualEnd());
			
			if(position.getBudgetItem() != null)
			{
				budgetItems.appendItem(position.getBudgetItem().getLabel(),position.getBudgetItem().getValue());
				budgetItems.setSelectedIndex(0);
			}
			
			for(WorktimeStatus status:WorktimeStatus.values())
			{
				Listitem listitem = new Listitem(status.name(), status.name());
				worktimes.appendChild(listitem);
				
				if(status.equals(position.getWorktimeStatus()))
					worktimes.setSelectedItem(listitem);
			}

			for(EmploymentStatus status:EmploymentStatus.values())
			{
				Listitem listitem = new Listitem(status.name(), status.name());
				employmentstatuses.appendChild(listitem);
				if(status.equals(position.getEmploymentStatus()))
					employmentstatuses.setSelectedItem(listitem);
			}

			for(SalaryStatus status:SalaryStatus.values())
			{
				Listitem listitem = new Listitem(status.name(), status.name());
				salarys.appendChild(listitem);
				if(status.equals(position.getSalaryStatus()))
					salarys.setSelectedItem(listitem);
			}

			for(PositionStatus status:PositionStatus.values())
			{
				Listitem listitem = new Listitem(status.name(), status.name());
				positionStatusTypes.appendChild(listitem);

				if(status.equals(PositionStatus.Planned))
					positionStatusTypes.setSelectedItem(listitem);
			}
			
			companys.setWidth("100%");

			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"90px"));
			grid.getColumns().appendChild(new Column());
			grid.getColumns().appendChild(new Column(null,null,"105px"));
			grid.getColumns().appendChild(new Column());
			grid.setSpan("1");

			Row row1 = new Row();
			row1.appendChild(new Label(lang.get("position.grid.column.company")));
			row1.appendChild(companys);
			row1.appendChild(new Label(lang.get("position.grid.column.worktype")));
			row1.appendChild(worktimes);
			
			Row row2 = new Row();
			row2.appendChild(new Label(lang.get("position.grid.column.start")));
			row2.appendChild(start);
			row2.appendChild(new Label(lang.get("position.grid.column.end")));
			row2.appendChild(end);
			
			Row row3 = new Row();
			row3.appendChild(new Label(lang.get("position.grid.column.actualstart")));
			row3.appendChild(actualStart);
			row3.appendChild(new Label(lang.get("position.grid.column.actualend")));
			row3.appendChild(actualEnd);
			
			Row row4 = new Row();
			row4.appendChild(new Label(lang.get("position.grid.column.employtype")));
			row4.appendChild(employmentstatuses);
			row4.appendChild(new Label(lang.get("position.grid.column.budget")));
			row4.appendChild(budgetItems);
			
			Row row5 = new Row();
			row5.appendChild(new Label(lang.get("position.grid.column.positiontype")));
			row5.appendChild(positionTypes);
			row5.appendChild(new Label(lang.get("position.grid.column.status")));
			row5.appendChild(positionStatusTypes);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
			rows.appendChild(row5);
		}
	}

	private void initResponsibilitys()
	{
		NRCToolbar toolbar = new NRCToolbar(responsibilitys);

		responsibilitys.getColumns().appendChild(new Column(null,null,"25px"));
		responsibilitys.getColumns().appendChild(new Column(lang.get("position.grid.column.start"),null,"125px"));
		responsibilitys.getColumns().appendChild(new Column(lang.get("position.grid.column.end"),null,"125px"));
		responsibilitys.getColumns().appendChild(new Column(lang.get("generic.grid.column.note"),null,null));
		responsibilitys.getColumns().appendChild(new Column());
		responsibilitys.getColumns().getLastChild().setVisible(false);
		responsibilitys.setSpan("3");

		Position position = service.findOne(RowUtils.id(row));
		if(position != null)
		{
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
		NRCToolbar toolbar = new NRCToolbar(fulfillments);

		fulfillments.getColumns().appendChild(new Column(null,null,"25px"));
		fulfillments.getColumns().appendChild(new Column(lang.get("position.grid.column.start"),null,"125px"));
		fulfillments.getColumns().appendChild(new Column(lang.get("position.grid.column.end"),null,"125px"));
		fulfillments.getColumns().appendChild(new Column(lang.get("generic.grid.column.person"),null,"175px"));
		fulfillments.getColumns().appendChild(new Column(lang.get("generic.grid.column.note"),null,null));
		fulfillments.getColumns().appendChild(new Column());
		fulfillments.getColumns().getLastChild().setVisible(false);
		fulfillments.setSpan("4");

		Position position = service.findOne(RowUtils.id(row));
		if(position != null)
		{
			for(PositionFulfillment fulfillment:position.getFulfillments())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox(fulfillment.getStart()));
				row.appendChild(Components.fullSpanDatebox(fulfillment.getEnd()));
				row.appendChild(Components.fullSpanSelect(fulfillment.getEmployee()));
				row.appendChild(Components.textBox(fulfillment.getDescription()));
				row.appendChild(new Label(fulfillment.getId()));

				fulfillments.getRows().appendChild(row);
			}
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
				row.appendChild(Components.fullSpanSelect(employmentService.findAllIn(utils.getAccessibleOrganizations(companys.getOrganization().getId())),true));
				row.appendChild(Components.textBox(null));
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
		NRCToolbar toolbar = new NRCToolbar(reportings);

		reportings.getColumns().appendChild(new Column(null,null,"25px"));
		reportings.getColumns().appendChild(new Column(lang.get("position.grid.column.start"),null,"125px"));
		reportings.getColumns().appendChild(new Column(lang.get("position.grid.column.end"),null,"125px"));
		reportings.getColumns().appendChild(new Column(lang.get("position.grid.column.position"),null,"175px"));
		reportings.getColumns().appendChild(new Column(lang.get("generic.grid.column.note"),null,null));
		reportings.getColumns().appendChild(new Column());
		reportings.getColumns().getLastChild().setVisible(false);
		reportings.setSpan("4");

		Position position = service.findOne(RowUtils.id(row));
		if(position != null)
		{
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
