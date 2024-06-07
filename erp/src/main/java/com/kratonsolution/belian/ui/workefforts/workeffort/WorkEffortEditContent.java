
package com.kratonsolution.belian.ui.workefforts.workeffort;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.orders.dm.OrderItem;
import com.kratonsolution.belian.orders.svc.OrderItemService;
import com.kratonsolution.belian.requirement.dm.WorkRequirement;
import com.kratonsolution.belian.requirement.dm.WorkRequirementFulfillment;
import com.kratonsolution.belian.requirement.svc.WorkRequirementService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.general.companystructure.CompanyStructureList;
import com.kratonsolution.belian.ui.general.party.PartyBox;
import com.kratonsolution.belian.ui.inventory.facility.FacilityList;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Numbers;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;
import com.kratonsolution.belian.workefforts.dm.WorkEffort;
import com.kratonsolution.belian.workefforts.dm.WorkEffortPartyAssignment;
import com.kratonsolution.belian.workefforts.dm.WorkEffortPartyRate;
import com.kratonsolution.belian.workefforts.dm.WorkEffortStatus;
import com.kratonsolution.belian.workefforts.dm.WorkOrderItemFulfillment;
import com.kratonsolution.belian.workefforts.svc.WorkEffortService;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class WorkEffortEditContent extends AbstractForm
{	
	private WorkEffortService service = Springs.get(WorkEffortService.class);

	private WorkRequirementService workRequirementService = Springs.get(WorkRequirementService.class);
	
	private OrderItemService orderItemService = Springs.get(OrderItemService.class);
	
	private Textbox number = Components.readOnlyTextBox(null, false);

	private Textbox name = Components.mandatoryTextBox(false);

	private Datebox created = Components.currentDatebox();

	private Datebox scheduledStart = Components.currentDatetime(false);

	private Datebox scheduledEnd = Components.datetime(false);

	private Datebox actualStart = Components.datetime(false);

	private Datebox actualEnd = Components.datetime(false);

	private Textbox description = Components.stdTextBox(null,false);

	private Decimalbox hours = Components.decimalbox(BigDecimal.ONE);

	private Decimalbox maxhours = Components.decimalbox(null);

	private Decimalbox maxmoney = Components.decimalbox(null);

	private WorkEffortTypeList typeList = new WorkEffortTypeList(false);

	private CompanyStructureList organizations = new CompanyStructureList(false);

	private WorkEffortPurposeTypeList purposeList = new WorkEffortPurposeTypeList(false);

	private Tabbox tabbox = new Tabbox();

	private Grid assignments = new Grid();

	private Grid statuses = new Grid();

	private Grid rates = new Grid();

	private Grid requirementFulfillments = new Grid();

	private Grid orderFulfillments = new Grid();

	private Row row;

	public WorkEffortEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
		initTabbox();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Flow.next(getParent(), new WorkEffortGridContent());
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(organizations.getDomain() == null)
					throw new WrongValueException(organizations,lang.get("message.field.empty"));

				if(created.getValue() == null)
					throw new WrongValueException(created,lang.get("message.field.empty"));

				if(scheduledStart.getValue() == null)
					throw new WrongValueException(scheduledStart,lang.get("message.field.empty"));

				if(scheduledEnd.getValue() == null)
					throw new WrongValueException(scheduledEnd,lang.get("message.field.empty"));

				if(typeList.getDomain() == null)
					throw new WrongValueException(typeList,lang.get("message.field.empty"));

				if(purposeList.getDomain() == null)
					throw new WrongValueException(purposeList,lang.get("message.field.empty"));

				WorkEffort effort = service.findById(RowUtils.id(row));
				if(effort != null)
				{
					effort.setActualEnd(DateTimes.timestamp(actualEnd.getValue()));
					effort.setActualStart(DateTimes.timestamp(actualStart.getValue()));
					effort.setCreationDate(DateTimes.sql(created.getValue()));
					effort.setDescription(description.getText());
					effort.setHours(hours.getValue());
					effort.setMaxAllowedHours(maxhours.getValue());
					effort.setMaxAllowedMoney(maxmoney.getValue());
					effort.setName(name.getText());
					effort.setOwner(organizations.getDomainAsRef());
					effort.setPurpose(purposeList.getDomain());
					effort.setScheduledEnd(DateTimes.timestamp(scheduledEnd.getValue()));
					effort.setScheduledStart(DateTimes.timestamp(scheduledStart.getValue()));
					effort.setType(typeList.getDomain());

					Map<String,WorkEffortPartyAssignment> assmap = new HashMap<>();
					Map<String,WorkEffortStatus> statusmap = new HashMap<>();
					Map<String,WorkEffortPartyRate> ratemap = new HashMap<>();

					for(WorkEffortPartyAssignment assignment:effort.getAssignments())
						assmap.put(assignment.getId(), assignment);

					for(WorkEffortStatus status:effort.getStatuses())
						statusmap.put(status.getId(), status);

					for(WorkEffortPartyRate rate:effort.getRates())
						ratemap.put(rate.getId(), rate);

					effort.getAssignments().clear();
					effort.getStatuses().clear();
					effort.getRates().clear();

					for(Component com:assignments.getRows().getChildren())
					{
						Row rw = (Row)com;

						PartyBox box = (PartyBox)com.getChildren().get(3);
						FacilityList facility = (FacilityList)com.getChildren().get(4);
						WorkEffortRoleTypeList role = (WorkEffortRoleTypeList)com.getChildren().get(5);

						WorkEffortPartyAssignment assignment = assmap.containsKey(RowUtils.id(rw))?assmap.get(RowUtils.id(rw)):new WorkEffortPartyAssignment();
						assignment.setEffort(effort);
						assignment.setStart(RowUtils.sql(rw, 1));
						assignment.setEnd(RowUtils.sql(rw, 2));
						assignment.setFacility(facility.getDomainAsRef());
						assignment.setParty(box.getDomainAsRef());
						assignment.setType(role.getDomain());

						effort.getAssignments().add(assignment);
					}

					for(Component com:statuses.getRows().getChildren())
					{
						Row rw = (Row)com;

						WorkEffortStatusTypeList type = (WorkEffortStatusTypeList)com.getChildren().get(3);

						WorkEffortStatus status = statusmap.containsKey(RowUtils.id(rw))?statusmap.get(RowUtils.id(rw)):new WorkEffortStatus();
						status.setEffort(effort);
						status.setEnd(RowUtils.sql(rw, 2));
						status.setStart(RowUtils.sql(rw, 1));
						status.setType(type.getDomain());

						effort.getStatuses().add(status);
					}

					for(Component com:rates.getRows().getChildren())
					{
						Row rw = (Row)com;

						PartyBox box = (PartyBox)com.getChildren().get(3);
						RateTypeList rateType = (RateTypeList)com.getChildren().get(5);

						WorkEffortPartyRate rate = ratemap.containsKey(RowUtils.id(rw))?ratemap.get(RowUtils.id(rw)):new WorkEffortPartyRate();
						rate.setEffort(effort);
						rate.setStart(RowUtils.sql(rw, 1));
						rate.setEnd(RowUtils.sql(rw, 2));
						rate.setParty(box.getDomainAsRef());
						rate.setType(rateType.getDomain());
						rate.setRate(RowUtils.decimal(rw, 4));
						rate.setCommend(RowUtils.string(rw, 6));

						effort.getRates().add(rate);
					}

					service.edit(effort);
				}

				Flow.next(getParent(), new WorkEffortGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		WorkEffort effort = service.findById(RowUtils.id(row));
		if(effort != null)
		{
			organizations.setDomainAsRef(effort.getOwner());
			scheduledStart.setValue(effort.getScheduledStart());
			number.setText(effort.getNumber());
			name.setText(effort.getName());
			scheduledEnd.setValue(effort.getScheduledEnd());
			created.setValue(effort.getCreationDate());
			actualStart.setValue(effort.getActualStart());
			typeList.setDomain(effort.getType());
			actualEnd.setValue(effort.getActualEnd());
			purposeList.setDomain(effort.getPurpose());
			maxhours.setValue(effort.getMaxAllowedHours());
			maxmoney.setValue(effort.getMaxAllowedMoney());
		}

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().appendChild(new Column(null,null,"150px"));
		grid.getColumns().appendChild(new Column());

		Row row0 = new Row();
		row0.appendChild(new Label(lang.get("workeffort.grid.column.number")));
		row0.appendChild(number);
		row0.appendChild(new Label());
		row0.appendChild(new Label());

		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("workeffort.grid.column.organization")));
		row1.appendChild(organizations);
		row1.appendChild(new Label(lang.get("workeffort.grid.column.scheduledStart")));
		row1.appendChild(scheduledStart);

		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("workeffort.grid.column.name")));
		row2.appendChild(name);
		row2.appendChild(new Label(lang.get("workeffort.grid.column.scheduledEnd")));
		row2.appendChild(scheduledEnd);

		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("workeffort.grid.column.creationDate")));
		row3.appendChild(created);
		row3.appendChild(new Label(lang.get("workeffort.grid.column.actualStart")));
		row3.appendChild(actualStart);

		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("workeffort.grid.column.type")));
		row4.appendChild(typeList);		
		row4.appendChild(new Label(lang.get("workeffort.grid.column.actualEnd")));
		row4.appendChild(actualEnd);

		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("workeffort.grid.column.purpose")));
		row5.appendChild(purposeList);
		row5.appendChild(new Label(lang.get("workeffort.grid.column.maxhours")));
		row5.appendChild(maxhours);

		Row row6 = new Row();
		row6.appendChild(new Label());
		row6.appendChild(new Label());
		row6.appendChild(new Label(lang.get("workeffort.grid.column.maxmoney")));
		row6.appendChild(maxmoney);

		rows.appendChild(row0);
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}

	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("workeffort.grid.column.assignments")));
		tabbox.getTabs().appendChild(new Tab(lang.get("workeffort.grid.column.statuses")));
		tabbox.getTabs().appendChild(new Tab(lang.get("workeffort.grid.column.rates")));
		tabbox.getTabs().appendChild(new Tab(lang.get("workeffort.grid.column.workrequirements")));
		tabbox.getTabs().appendChild(new Tab(lang.get("workeffort.grid.column.workorders")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());

		appendChild(tabbox);

		initAssignments();
		initStatuses();
		initRates();
		initWorkRequirements();
		initWorkOrders();
	}

	private void initAssignments()
	{
		NRCToolbar nrc = new NRCToolbar(assignments);

		assignments.setWidth("100%");
		assignments.setEmptyMessage(lang.get("message.grid.empty"));
		assignments.appendChild(new Columns());
		assignments.appendChild(new Rows());
		assignments.getColumns().appendChild(new Column(null,null,"25px"));
		assignments.getColumns().appendChild(new Column(lang.get("workeffort.grid.column.start"),null,"115px"));
		assignments.getColumns().appendChild(new Column(lang.get("workeffort.grid.column.end"),null,"115px"));
		assignments.getColumns().appendChild(new Column(lang.get("workeffort.grid.column.party"),null,"150px"));
		assignments.getColumns().appendChild(new Column(lang.get("workeffort.grid.column.facility"),null,"150px"));
		assignments.getColumns().appendChild(new Column(lang.get("workeffort.grid.column.type"),null,"125px"));
		assignments.getColumns().appendChild(new Column());
		assignments.getColumns().getLastChild().setVisible(false);
		assignments.setSpan("3");

		WorkEffort effort = service.findById(RowUtils.id(row));
		if(effort != null)
		{
			for(WorkEffortPartyAssignment assignment:effort.getAssignments())
			{
				PartyBox box = new PartyBox(false,true,null);
				box.setDomainAsRef(assignment.getParty());

				FacilityList facilityList = new FacilityList(true);
				facilityList.setDomainAsRef(assignment.getFacility());

				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullSpanDatebox(assignment.getStart()));
				row.appendChild(Components.fullSpanDatebox(assignment.getEnd()));
				row.appendChild(box);
				row.appendChild(facilityList);
				row.appendChild(new WorkEffortRoleTypeList(true,assignment.getType()));
				row.appendChild(new Label(assignment.getId()));

				assignments.getRows().appendChild(row);
			}
		}

		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullSpanDatebox(DateTimes.currentDate()));
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(new PartyBox(false,true,null));
				row.appendChild(Components.fullspanDecimalbox(BigDecimal.ZERO));
				row.appendChild(new FacilityList(true));
				row.appendChild(new WorkEffortRoleTypeList(true));
				row.appendChild(new Label(UUID.randomUUID().toString()));

				assignments.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getFirstChild().appendChild(nrc);
		tabbox.getTabpanels().getFirstChild().appendChild(assignments);
	}

	private void initStatuses()
	{
		NRCToolbar nrc = new NRCToolbar(statuses);

		statuses.setWidth("100%");
		statuses.setEmptyMessage(lang.get("message.grid.empty"));
		statuses.appendChild(new Columns());
		statuses.appendChild(new Rows());
		statuses.getColumns().appendChild(new Column(null,null,"25px"));
		statuses.getColumns().appendChild(new Column(lang.get("workeffort.grid.column.start"),null,"135px"));
		statuses.getColumns().appendChild(new Column(lang.get("workeffort.grid.column.end"),null,"135px"));
		statuses.getColumns().appendChild(new Column(lang.get("workeffort.grid.column.type"),null,"125px"));
		statuses.getColumns().appendChild(new Column());
		statuses.getColumns().getLastChild().setVisible(false);
		statuses.setSpan("3");

		WorkEffort effort = service.findById(RowUtils.id(row));
		if(effort != null)
		{
			for(WorkEffortStatus status:effort.getStatuses())
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullSpanDatebox(status.getStart()));
				row.appendChild(Components.fullSpanDatebox(status.getEnd()));
				row.appendChild(new WorkEffortStatusTypeList(true,status.getType()));
				row.appendChild(new Label(status.getId()));

				statuses.getRows().appendChild(row);
			}
		}

		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullSpanDatebox(DateTimes.currentDate()));
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(new WorkEffortStatusTypeList(true));
				row.appendChild(new Label(UUID.randomUUID().toString()));

				statuses.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(1).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(1).appendChild(statuses);
	}

	private void initRates()
	{
		NRCToolbar nrc = new NRCToolbar(rates);

		rates.setWidth("100%");
		rates.setEmptyMessage(lang.get("message.grid.empty"));
		rates.appendChild(new Columns());
		rates.appendChild(new Rows());
		rates.getColumns().appendChild(new Column(null,null,"25px"));
		rates.getColumns().appendChild(new Column(lang.get("workeffort.grid.column.start"),null,"115px"));
		rates.getColumns().appendChild(new Column(lang.get("workeffort.grid.column.end"),null,"115px"));
		rates.getColumns().appendChild(new Column(lang.get("workeffort.grid.column.party"),null,"150px"));
		rates.getColumns().appendChild(new Column(lang.get("workeffort.grid.column.rate"),null,"100px"));
		rates.getColumns().appendChild(new Column(lang.get("workeffort.grid.column.type"),null,"185px"));
		rates.getColumns().appendChild(new Column(lang.get("workeffort.grid.column.commend"),null,"135px"));
		rates.getColumns().appendChild(new Column());
		rates.getColumns().getLastChild().setVisible(false);
		rates.setSpan("3");

		WorkEffort effort = service.findById(RowUtils.id(row));
		if(effort != null)
		{
			for(WorkEffortPartyRate rate:effort.getRates())
			{
				PartyBox box = new PartyBox(false,true,null);
				box.setDomainAsRef(rate.getParty());

				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullSpanDatebox(rate.getStart()));
				row.appendChild(Components.fullSpanDatebox(rate.getEnd()));
				row.appendChild(box);
				row.appendChild(Components.fullspanDecimalbox(rate.getRate()));
				row.appendChild(new RateTypeList(true,rate.getType()));
				row.appendChild(Components.textBox(rate.getCommend()));
				row.appendChild(new Label(rate.getId()));

				rates.getRows().appendChild(row);
			}
		}

		nrc.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullSpanDatebox(DateTimes.currentDate()));
				row.appendChild(Components.fullSpanDatebox(null));
				row.appendChild(new PartyBox(false,true,null));
				row.appendChild(Components.fullspanDecimalbox(BigDecimal.ZERO));
				row.appendChild(new RateTypeList(true));
				row.appendChild(Components.textBox(null));
				row.appendChild(new Label(UUID.randomUUID().toString()));

				rates.getRows().appendChild(row);
			}
		});

		tabbox.getTabpanels().getChildren().get(2).appendChild(nrc);
		tabbox.getTabpanels().getChildren().get(2).appendChild(rates);
	}

	private void initWorkRequirements()
	{
		requirementFulfillments.setWidth("100%");
		requirementFulfillments.setEmptyMessage(lang.get("message.grid.empty"));
		requirementFulfillments.appendChild(new Columns());
		requirementFulfillments.appendChild(new Rows());
		requirementFulfillments.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.number"),null,"100px"));
		requirementFulfillments.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.date"),null,"115px"));
		requirementFulfillments.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.reason"),null,"200px"));
		requirementFulfillments.getColumns().appendChild(new Column(lang.get("workrequirement.grid.column.description"),null,"200px"));
		requirementFulfillments.setSpan("2");

		WorkEffort effort = service.findById(RowUtils.id(row));
		if(effort != null)
		{
			for(WorkRequirementFulfillment fill:effort.getFulfillments())
			{
				WorkRequirement work = workRequirementService.findById(fill.getWorkRequirement().getId());
				if(work != null)
				{
					Row row = new Row();
					row.appendChild(new Label(work.getNumber()));
					row.appendChild(new Label(DateTimes.format(work.getCreationDate())));
					row.appendChild(new Label(work.getReason()));
					row.appendChild(new Label(work.getDescription()));

					requirementFulfillments.getRows().appendChild(row);
				}
			}
		}

		tabbox.getTabpanels().getChildren().get(3).appendChild(requirementFulfillments);
	}

	private void initWorkOrders()
	{
		orderFulfillments.setWidth("100%");
		orderFulfillments.setEmptyMessage(lang.get("message.grid.empty"));
		orderFulfillments.appendChild(new Columns());
		orderFulfillments.appendChild(new Rows());
		orderFulfillments.getColumns().appendChild(new Column(lang.get("order.grid.column.number"),null,"100px"));
		orderFulfillments.getColumns().appendChild(new Column(lang.get("order.grid.column.entrydate"),null,"115px"));
		orderFulfillments.getColumns().appendChild(new Column(lang.get("order.items.grid.column.product"),null,"135px"));
		orderFulfillments.getColumns().appendChild(new Column(lang.get("order.items.grid.column.quantity"),null,"100px"));
		orderFulfillments.getColumns().appendChild(new Column(lang.get("order.items.grid.column.note"),null,"150px"));
		orderFulfillments.setSpan("2");

		WorkEffort effort = service.findById(RowUtils.id(row));
		if(effort != null)
		{
			for(WorkOrderItemFulfillment fill:effort.getItemFulfillments())
			{
				OrderItem item = orderItemService.findById(fill.getOrderItem().getId());
				if(item != null)
				{
					Row row = new Row();
					row.appendChild(new Label(item.getOrder().getNumber()));
					row.appendChild(new Label(DateTimes.format(item.getOrder().getEntryDate())));
					row.appendChild(new Label(item.getProduct().getValue()));
					row.appendChild(new Label(Numbers.format(item.getQuantity())));
					row.appendChild(new Label(item.getNote()));

					orderFulfillments.getRows().appendChild(row);
				}
			}
		}

		tabbox.getTabpanels().getChildren().get(4).appendChild(orderFulfillments);
	}
}
