/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.budget;

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
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.accounting.dm.Budget;
import com.kratonsolution.belian.accounting.dm.BudgetItem;
import com.kratonsolution.belian.accounting.dm.BudgetRole;
import com.kratonsolution.belian.accounting.dm.BudgetStatus;
import com.kratonsolution.belian.accounting.dm.BudgetType;
import com.kratonsolution.belian.accounting.svc.BudgetService;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.global.dm.RoledType;
import com.kratonsolution.belian.global.dm.StatusType;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BudgetFormContent extends FormContent
{	
	private BudgetService service = Springs.get(BudgetService.class);
	
	private PersonService personService = Springs.get(PersonService.class);
	
	private SessionUtils sessionUtils = Springs.get(SessionUtils.class);
	
	private Datebox start = Components.currentDatebox();
	
	private Datebox end = Components.datebox();
	
	private Listbox types = Components.newSelect();
	
	private Textbox comment = new Textbox();
	
	private Listbox targets = Components.newSelect();
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid itemsGrid = new Grid();
	
	private Grid rolesGrid = new Grid();
	
	public BudgetFormContent()
	{
		super();
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
				Flow.next(getParent(), new BudgetGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Budget budget = new Budget();
				budget.setType(BudgetType.valueOf(Components.string(types)));
				budget.setOrganization(sessionUtils.getOrganization());
				budget.setStart(DateTimes.sql(start.getValue()));
				budget.setEnd(DateTimes.sql(end.getValue()));
				budget.setComment(comment.getText());
				
				BudgetStatus status = new BudgetStatus();
				status.setBudget(budget);
				status.setDate(DateTimes.sql(start.getValue()));
				status.setDescription("Just Created");
				status.setType(StatusType.Created);
				
				budget.getStatuses().add(status);
				budget.setLastStatus(status);
				
				BudgetRole initiator = new BudgetRole();
				initiator.setBudget(budget);
				initiator.setParty(sessionUtils.getUser().getPerson());
				initiator.setType(RoledType.Initiator);
				
				BudgetRole requested = new BudgetRole();
				requested.setBudget(budget);
				requested.setParty(sessionUtils.getOrganization());
				requested.setType(RoledType.Requested);
				
				budget.getRoles().add(initiator);
				budget.getRoles().add(requested);
				
				for(Component com:itemsGrid.getRows().getChildren())
				{
					Row row = (Row)com;
					
					BudgetItem item = new BudgetItem();
					item.setAmount(RowUtils.decimal(row, 2));
					item.setBudget(budget);
					item.setJustification(RowUtils.string(row, 4));
					item.setPurpose(RowUtils.string(row, 3));
					item.setSequence(RowUtils.integer(row, 1));
					
					budget.getItems().add(item);
				}
				
				for(Component com:rolesGrid.getRows().getChildren())
				{
					Row row = (Row)com;
					
					BudgetRole role = new BudgetRole();
					role.setBudget(budget);
					role.setParty(personService.findOne(RowUtils.string(row, 1)));
					role.setType(RoledType.valueOf(RowUtils.string(row, 2)));
					
					budget.getRoles().add(role);
				}
				
				service.add(budget);
				
				Flow.next(getParent(), new BudgetEditContent(budget));
			}
		});
	}

	@Override
	public void initForm()
	{
		comment.setWidth("300px");
		targets.appendItem(sessionUtils.getOrganization().getName(),sessionUtils.getOrganization().getId());
		
		for(BudgetType type:BudgetType.values())
			types.appendItem(type.name(), type.name());

		Components.setDefault(types);
		Components.setDefault(targets);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Type"));
		row1.appendChild(types);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Party"));
		row2.appendChild(targets);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Start"));
		row3.appendChild(start);
		
		Row row4 = new Row();
		row4.appendChild(new Label("End"));
		row4.appendChild(end);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Comment"));
		row5.appendChild(comment);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
	
	private void initTabbox()
	{
		tabbox.setWidth("100%");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab("Item(s)"));
		tabbox.getTabs().appendChild(new Tab("Role(s)"));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		appendChild(tabbox);
		
		initItemsGrid();
		initRolesGrid();
	}
	
	private void initItemsGrid()
	{
		NRCToolbar bar = new NRCToolbar(itemsGrid);
		
		itemsGrid.appendChild(new Columns());
		itemsGrid.appendChild(new Rows());
		itemsGrid.getColumns().appendChild(new Column(null,null,"25px"));
		itemsGrid.getColumns().appendChild(new Column("SEQ",null,"55px"));
		itemsGrid.getColumns().appendChild(new Column("Amount",null,"125px"));
		itemsGrid.getColumns().appendChild(new Column("Purpose",null,"150px"));
		itemsGrid.getColumns().appendChild(new Column("Justification",null,"150px"));
		itemsGrid.setSpan("4");
		
		bar.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			int index = 1;
			
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				try
				{
					Row row = new Row();
					row.appendChild(Components.checkbox(false));
					row.appendChild(Components.readOnlyDoubleBox(index));
					row.appendChild(Components.doubleBox(1d));
					row.appendChild(Components.mandatoryTextBox());
					row.appendChild(Components.mandatoryTextBox());
					
					itemsGrid.getRows().appendChild(row);
					
					index++;
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		tabbox.getTabpanels().getChildren().get(0).appendChild(bar);
		tabbox.getTabpanels().getChildren().get(0).appendChild(itemsGrid);
	}
	
	private void initRolesGrid()
	{
		NRCToolbar bar = new NRCToolbar(rolesGrid);
		
		rolesGrid.appendChild(new Columns());
		rolesGrid.appendChild(new Rows());
		rolesGrid.getColumns().appendChild(new Column(null,null,"25px"));
		rolesGrid.getColumns().appendChild(new Column("Person",null,"150px"));
		rolesGrid.getColumns().appendChild(new Column("Type",null,"125px"));
		rolesGrid.setSpan("1");
		
		bar.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				try
				{
					Row row = new Row();
					row.appendChild(Components.checkbox(false));
					row.appendChild(Components.fullSpanSelect(personService.findAll(),true));
					
					Listbox listbox = Components.fullSpanSelect();
					listbox.appendItem(RoledType.Reviewer.name(), RoledType.Reviewer.name());
					listbox.appendItem(RoledType.Approver.name(), RoledType.Approver.name());
					
					row.appendChild(listbox);
					
					rolesGrid.getRows().appendChild(row);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		tabbox.getTabpanels().getChildren().get(1).appendChild(bar);
		tabbox.getTabpanels().getChildren().get(1).appendChild(rolesGrid);
	}
}
