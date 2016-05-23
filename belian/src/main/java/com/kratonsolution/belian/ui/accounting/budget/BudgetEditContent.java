/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.budget;

import java.util.Iterator;

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
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.accounting.dm.Budget;
import com.kratonsolution.belian.accounting.dm.BudgetItem;
import com.kratonsolution.belian.accounting.dm.BudgetStatus;
import com.kratonsolution.belian.accounting.dm.BudgetType;
import com.kratonsolution.belian.accounting.svc.BudgetService;
import com.kratonsolution.belian.common.Dates;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.global.dm.StatusType;
import com.kratonsolution.belian.global.svc.EconomicAgentService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BudgetEditContent extends FormContent
{	
	private BudgetService service = Springs.get(BudgetService.class);

	private OrganizationService organizationService = Springs.get(OrganizationService.class);

	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private EconomicAgentService personService = Springs.get(EconomicAgentService.class);
	
	private SessionUtils sessionUtils = Springs.get(SessionUtils.class);

	private Datebox start = Components.currentDatebox();

	private Datebox end = Components.datebox();

	private Listbox types = Components.newSelect();

	private Textbox comment = new Textbox();

	private Listbox targets = Components.newSelect();

	private Tabbox tabbox = new Tabbox();

	private Grid budgetItems = new Grid();

	private Grid statuses = new Grid();

	private Grid reviews = new Grid();
	
	private BudgetRolePanel rolePanel;
	
	private Budget budget;
	
	public BudgetEditContent(Row row)
	{
		super();
		
		if(row != null)
			this.budget = service.findOne(RowUtils.string(row, 6));

		init();
	}
	
	public BudgetEditContent(Budget budget)
	{
		super();
		this.budget = budget;
		init();
	}

	private void init()
	{
		initToolbar();
		initForm();

		rolePanel = new BudgetRolePanel(budget);
		
		tabbox.setHflex("1");
		tabbox.setVflex("1");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab("Item(s)"));
		tabbox.getTabs().appendChild(new Tab("Statuses"));
		tabbox.getTabs().appendChild(new Tab("Party Role(s)"));
		tabbox.getTabs().appendChild(new Tab("Review(s)"));
		tabbox.getTabs().appendChild(new Tab("Revision(s)"));
		tabbox.getTabpanels().appendChild(new BudgetItemPanel(budget));
		tabbox.getTabpanels().appendChild(new BudgetStatusPanel(budget));
		tabbox.getTabpanels().appendChild(rolePanel);
		tabbox.getTabpanels().appendChild(new BudgetReviewPanel(budget));
		tabbox.getTabpanels().appendChild(new BudgetRevisionPanel(budget));

		appendChild(tabbox);
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

		toolbar.getSave().setDisabled(budget.isDone());
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(budget != null)
				{
					budget.setType(BudgetType.valueOf(Components.string(types)));
					budget.setStart(Dates.sql(start.getValue()));
					budget.setEnd(Dates.sql(end.getValue()));
					budget.setComment(comment.getText());
					
					budget.getItems().clear();
					budget.getReviews().clear();
					budget.getReviews().clear();

					service.edit(budget);

					Iterator<Component> iterator = budgetItems.getRows().getChildren().iterator();
					while (iterator.hasNext())
					{
						Row comp = (Row) iterator.next();

						BudgetItem item = new BudgetItem();
						item.setBudget(budget);
						item.setSequence(RowUtils.integer(comp, 1));
						item.setAmount(RowUtils.decimal(comp, 2));
						item.setPurpose(RowUtils.string(comp, 3));
						item.setJustification(RowUtils.string(comp, 4));
						item.setId(RowUtils.string(comp, 5));

						budget.getItems().add(item);
					}

					for(Component component:statuses.getRows().getChildren())
					{
						Row row = (Row)component;

						BudgetStatus status = new BudgetStatus();
						status.setBudget(budget);
						status.setDate(RowUtils.sql(row, 1));
						status.setType(StatusType.valueOf(RowUtils.string(row, 2)));
						status.setDescription(RowUtils.string(row, 3));
						status.setId(RowUtils.string(row, 4));

						budget.getStatuses().add(status);
					}
				}

				service.edit(budget);

				Flow.next(getParent(), new BudgetGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		if(budget != null)
		{
			types.setWidth("250px");
			start.setValue(budget.getStart());
			end.setValue(budget.getEnd());
			comment.setWidth("300px");
			comment.setValue(budget.getComment());
			
			for(BudgetType type: BudgetType.values())
			{
				Listitem listitem = new Listitem(type.name(), type.name());
				types.appendChild(listitem);

				if(budget.getType().equals(type))
					types.setSelectedItem((Listitem)types.getLastChild());
			}

			targets.appendItem(budget.getOrganization().getName(),budget.getOrganization().getId());
			targets.setSelectedIndex(0);

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
	}
}
