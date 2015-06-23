/**
 * 
 */
package com.kratonsolution.belian.ui.budget;

import java.util.Date;
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
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.accounting.dm.Budget;
import com.kratonsolution.belian.accounting.dm.BudgetItem;
import com.kratonsolution.belian.accounting.dm.BudgetReview;
import com.kratonsolution.belian.accounting.dm.BudgetReview.ReviewResult;
import com.kratonsolution.belian.accounting.dm.BudgetStatus;
import com.kratonsolution.belian.accounting.dm.BudgetType;
import com.kratonsolution.belian.accounting.svc.BudgetService;
import com.kratonsolution.belian.accounting.svc.BudgetTypeService;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Dates;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class BudgetEditContent extends FormContent
{	
	private BudgetService service = Springs.get(BudgetService.class);

	private BudgetTypeService typeService = Springs.get(BudgetTypeService.class);
	
	private SessionUtils sessionUtils = Springs.get(SessionUtils.class);
	
	private PersonService personService = Springs.get(PersonService.class);

	private Datebox start = new Datebox(new Date());

	private Datebox end = new Datebox();

	private Listbox types = Components.newSelect();

	private Textbox description = new Textbox();

	private Listbox owners = Components.newSelect();
	
	private Tabbox tabbox = new Tabbox();
	
	private Grid budgetItems = new Grid();
	
	private Grid statuses = new Grid();
	
	private Grid reviews = new Grid();
	
	private Row row;

	public BudgetEditContent(Row row)
	{
		super();
		this.row = row;
		
		initToolbar();
		initForm();
		
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab("Budget Items"));
		tabbox.getTabs().appendChild(new Tab("Budget Status"));
		tabbox.getTabs().appendChild(new Tab("Budget Review"));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		appendChild(tabbox);
	
		initItems();
		initStatus();
		initReviews();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				BudgetWindow window = (BudgetWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Budget budget = service.findOne(RowUtils.string(row, 5));
				if(budget != null)
				{
					budget.setStart(start.getValue());
					budget.setEnd(end.getValue());
					budget.setType(typeService.findOne(Components.string(types)));
					budget.setDescription(description.getText());
					budget.getItems().clear();
					budget.getStatuses().clear();
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
						status.setDate(RowUtils.date(row, 1));
						status.setType(BudgetStatus.StatusType.valueOf(RowUtils.string(row, 2)));
						status.setDescription(RowUtils.string(row, 3));
						status.setId(RowUtils.string(row, 4));
						
						budget.getStatuses().add(status);
					}
					
					for(Component component:reviews.getRows().getChildren())
					{
						Row row = (Row)component;
						
						BudgetReview review = new BudgetReview();
						review.setBudget(budget);
						review.setDate(RowUtils.date(row, 1));
						review.setPerson(personService.findOne(RowUtils.string(row, 2)));
						review.setResult(ReviewResult.valueOf(RowUtils.string(row, 3)));
						review.setComment(RowUtils.string(row, 4));
						review.setId(RowUtils.string(row, 5));
						
						budget.getReviews().add(review);
					}
				}

				service.edit(budget);
				
				BudgetWindow window = (BudgetWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		Budget budget = service.findOne(RowUtils.string(row, 5));
		
		start.setWidth("150px");
		start.setValue(budget.getStart());
		start.setConstraint("no empty");

		end.setWidth("150px");
		end.setValue(budget.getEnd());
		
		types.setWidth("250px");
		
		description.setWidth("300px");
		description.setValue(budget.getDescription());
		
		for(BudgetType type: typeService.findAll())
		{
			Listitem listitem = new Listitem(type.getName(), type.getId());
			types.appendChild(listitem);
			
			if(budget.getType().getId().equals(type.getId()))
				types.setSelectedItem(listitem);
		}
		
		for(Organization organization:sessionUtils.getOrganizations())
		{
			Listitem listitem = new Listitem(organization.getName(),organization.getId());
			owners.appendChild(listitem);
			
			if(organization.getId().equals(budget.getOwner().getId()))
				owners.setSelectedItem(listitem);
		}
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("From"));
		row1.appendChild(start);
		
		Row row2 = new Row();
		row2.appendChild(new Label("To"));
		row2.appendChild(end);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Type"));
		row3.appendChild(types);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Owner"));
		row4.appendChild(owners);
		
		Row row5 = new Row();
		row5.appendChild(new Label("Description"));
		row5.appendChild(description);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
	
	private void initItems()
	{
		NRCToolbar toolbar = new NRCToolbar();
		
		budgetItems.appendChild(new Rows());
		budgetItems.appendChild(new Columns());
		budgetItems.getColumns().appendChild(new Column(null,null,"25px"));
		budgetItems.getColumns().appendChild(new Column("SEQ",null,"45px"));
		budgetItems.getColumns().appendChild(new Column("Amount",null,"150px"));
		budgetItems.getColumns().appendChild(new Column("Purpose",null,"200px"));
		budgetItems.getColumns().appendChild(new Column("Justification",null,"250px"));
		budgetItems.getColumns().appendChild(new Column(null,null,"1px"));
		budgetItems.getColumns().getChildren().get(5).setVisible(false);
		budgetItems.setSpan("4");
		
		Budget budget = service.findOne(RowUtils.string(row, 5));
		for(BudgetItem item:budget.getItems())
		{
			Row row = new Row();
			row.appendChild(Components.checkbox(false));
			row.appendChild(Components.readOnlyDoubleBox(budgetItems.getRows().getChildren().size()+1));
			row.appendChild(Components.doubleBox(item.getAmount().doubleValue()));
			row.appendChild(Components.mandatoryTextBox(item.getPurpose()));
			row.appendChild(Components.mandatoryTextBox(item.getJustification()));
			row.appendChild(new Label(item.getId()));
			
			budgetItems.getRows().appendChild(row);
		}
		
		toolbar.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.readOnlyDoubleBox(budgetItems.getRows().getChildren().size()+1));
				row.appendChild(Components.doubleBox());
				row.appendChild(Components.mandatoryTextBox());
				row.appendChild(Components.mandatoryTextBox());
				row.appendChild(new Label(UUID.randomUUID().toString()));
				
				budgetItems.getRows().appendChild(row);
			}
		});
		
		toolbar.getRemove().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Iterator<Component> iterator = budgetItems.getRows().getChildren().iterator();
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
				budgetItems.getRows().getChildren().clear();
			}
		});
		
		tabbox.getTabpanels().getChildren().get(0).appendChild(toolbar);
		tabbox.getTabpanels().getChildren().get(0).appendChild(budgetItems);
	}
	
	private void initStatus()
	{
		NRCToolbar toolbar = new NRCToolbar();
		
		statuses.appendChild(new Rows());
		statuses.appendChild(new Columns());
		statuses.getColumns().appendChild(new Column(null,null,"25px"));
		statuses.getColumns().appendChild(new Column("Date",null,"135px"));
		statuses.getColumns().appendChild(new Column("Type",null,"150px"));
		statuses.getColumns().appendChild(new Column("Description",null,"200px"));
		statuses.getColumns().appendChild(new Column(null,null,"1px"));
		statuses.getColumns().getChildren().get(4).setVisible(false);
		statuses.setSpan("3");
		
		Budget budget = service.findOne(RowUtils.string(row, 5));
		for(BudgetStatus item:budget.getStatuses())
		{
			Row row = new Row();
			row.appendChild(Components.checkbox(false));
			row.appendChild(Components.readOnlyTextBox(Dates.format(item.getDate())));
			row.appendChild(Components.readOnlyTextBox(item.getType().name()));
			row.appendChild(Components.readOnlyTextBox(item.getDescription()));
			row.appendChild(new Label(item.getId()));
			
			statuses.getRows().appendChild(row);
		}
		
		toolbar.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Listbox types = Components.newSelect();
				types.appendChild(new Listitem("SUBMITTED","SUBMITTED"));
				types.appendChild(new Listitem("REVIEWED","REVIEWED"));
				types.appendChild(new Listitem("APPROVED","APPROVED"));
				types.appendChild(new Listitem("REJECTED","REJECTED"));
				types.appendChild(new Listitem("NEEDMODIFICATION","NEEDMODIFICATION"));
				types.setSelectedIndex(0);
				types.setWidth("100%");
				
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(types);
				row.appendChild(Components.mandatoryTextBox());
				row.appendChild(new Label(UUID.randomUUID().toString()));
				
				statuses.getRows().appendChild(row);
			}
		});
		
		toolbar.getRemove().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Iterator<Component> iterator = statuses.getRows().getChildren().iterator();
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
				statuses.getRows().getChildren().clear();
			}
		});
		
		tabbox.getTabpanels().getChildren().get(1).appendChild(toolbar);
		tabbox.getTabpanels().getChildren().get(1).appendChild(statuses);
	}
	
	private void initReviews()
	{
		NRCToolbar toolbar = new NRCToolbar();
		
		reviews.appendChild(new Rows());
		reviews.appendChild(new Columns());
		reviews.getColumns().appendChild(new Column(null,null,"25px"));
		reviews.getColumns().appendChild(new Column("Date",null,"135px"));
		reviews.getColumns().appendChild(new Column("Reviewer",null,"175px"));
		reviews.getColumns().appendChild(new Column("Status",null,"100px"));
		reviews.getColumns().appendChild(new Column("Comment",null,"200px"));
		reviews.getColumns().appendChild(new Column(null,null,"1px"));
		reviews.getColumns().getChildren().get(5).setVisible(false);
		reviews.setSpan("4");
		
		Budget budget = service.findOne(RowUtils.string(row, 5));
		for(BudgetReview item:budget.getReviews())
		{
			Row row = new Row();
			row.appendChild(Components.checkbox(false));
			row.appendChild(Components.readOnlyTextBox(Dates.format(item.getDate())));
			row.appendChild(Components.readOnlyTextBox(item.getPerson().getName()));
			row.appendChild(Components.readOnlyTextBox(item.getResult().name()));
			row.appendChild(Components.readOnlyTextBox(item.getComment()));
			row.appendChild(new Label(item.getId()));
			
			reviews.getRows().appendChild(row);
		}
		
		toolbar.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Row row = new Row();
				
				Listbox results = Components.newSelect();
				results.appendChild(new Listitem("ACCEPTED","ACCEPTED"));
				results.appendChild(new Listitem("REJECTED","REJECTED"));
				results.setSelectedIndex(0);
				results.setWidth("100%");
				
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(Components.newSelect(personService.findAllBudgetReviewer(Components.string(owners)),true));
				row.appendChild(results);
				row.appendChild(Components.mandatoryTextBox());
				row.appendChild(new Label(UUID.randomUUID().toString()));
				
				reviews.getRows().appendChild(row);
			}
		});
		
		toolbar.getRemove().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Iterator<Component> iterator = statuses.getRows().getChildren().iterator();
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
				reviews.getRows().getChildren().clear();
			}
		});
		
		tabbox.getTabpanels().getChildren().get(2).appendChild(toolbar);
		tabbox.getTabpanels().getChildren().get(2).appendChild(reviews);
	}
}
