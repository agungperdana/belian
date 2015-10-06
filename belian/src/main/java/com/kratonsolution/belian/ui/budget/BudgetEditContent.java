/**
 * 
 */
package com.kratonsolution.belian.ui.budget;

import java.util.Iterator;
import java.util.UUID;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;
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
import com.kratonsolution.belian.accounting.dm.Budget.Type;
import com.kratonsolution.belian.accounting.dm.BudgetItem;
import com.kratonsolution.belian.accounting.dm.BudgetReviewResult;
import com.kratonsolution.belian.accounting.dm.BudgetStatus;
import com.kratonsolution.belian.accounting.svc.BudgetService;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.OrganizationUnit;
import com.kratonsolution.belian.general.svc.OrganizationService;
import com.kratonsolution.belian.general.svc.OrganizationUnitService;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.global.dm.ReviewResult;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Dates;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BudgetEditContent extends FormContent
{	
	private BudgetService service = Springs.get(BudgetService.class);

	private OrganizationUnitService unitService = Springs.get(OrganizationUnitService.class);

	private OrganizationService organizationService = Springs.get(OrganizationService.class);

	private PersonService personService = Springs.get(PersonService.class);
	
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
				Budget budget = service.findOne(RowUtils.string(row, 6));
				if(budget != null)
				{
					budget.setType(Type.valueOf(Components.string(types)));
					budget.setPartyRequested(organizationService.findOne(Components.string(targets)));
					budget.setStart(start.getValue());
					budget.setEnd(end.getValue());
					budget.setComment(comment.getText());
					
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

						ReviewResult review = new BudgetReviewResult();
						review.setReviewable(budget);
						review.setContent("Need Review for Budget "+budget.getComment());
						review.setDate(RowUtils.date(row, 1));
						review.setOwner(personService.findOne(RowUtils.string(row, 2)));
						review.setType(ReviewResult.Type.valueOf(RowUtils.string(row, 3)));
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
		Budget budget = service.findOne(RowUtils.string(row, 6));
		if(budget != null)
		{
			types.setWidth("250px");
			start.setValue(budget.getStart());
			end.setValue(budget.getEnd());
			comment.setWidth("300px");
			comment.setValue(budget.getComment());
			
			for(Type type: Type.values())
			{
				Listitem listitem = new Listitem(type.name(), type.name());
				types.appendChild(listitem);

				if(budget.getType().equals(type))
					types.setSelectedItem((Listitem)types.getLastChild());
			}

			for(OrganizationUnit unit:unitService.findAll())
			{
				Listitem listitem = new Listitem(unit.getParty().getLabel(),unit.getParty().getValue());
				targets.appendChild(listitem);

				if(budget.getPartyRequested().getId().equals(unit.getParty().getId()))
					targets.setSelectedItem(listitem);
			}

			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"75px"));
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

		Budget budget = service.findOne(RowUtils.string(row, 6));
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
		statuses.appendChild(new Rows());
		statuses.appendChild(new Columns());
		statuses.getColumns().appendChild(new Column(null,null,"25px"));
		statuses.getColumns().appendChild(new Column("Date",null,"135px"));
		statuses.getColumns().appendChild(new Column("Type",null,"150px"));
		statuses.getColumns().appendChild(new Column("Comment",null,"200px"));
		statuses.getColumns().appendChild(new Column(null,null,"1px"));
		statuses.getColumns().getChildren().get(4).setVisible(false);
		statuses.setSpan("3");

		Budget budget = service.findOne(RowUtils.string(row, 6));
		for(BudgetStatus item:budget.getStatuses())
		{
			Row row = new Row();
			row.appendChild(Components.readOnlyCheckbox());
			row.appendChild(Components.fullSpanReadOnlyDatebox(item.getDate()));
			row.appendChild(Components.readOnlyTextBox(item.getType().name()));
			row.appendChild(Components.readOnlyTextBox(item.getDescription()));
			row.appendChild(new Label(item.getId()));

			statuses.getRows().appendChild(row);
		}

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

		Budget budget = service.findOne(RowUtils.string(row, 6));
		for(ReviewResult item:budget.getReviews())
		{
			Checkbox checkbox = Components.checkbox(false);
			
			Row row = new Row();
			row.appendChild(checkbox);
			row.appendChild(Components.readOnlyTextBox(Dates.format(item.getDate())));
			row.appendChild(Components.readOnlyTextBox(item.getOwner().getName()));
			row.appendChild(Components.readOnlyTextBox(item.getType().name()));
			row.appendChild(Components.readOnlyTextBox(item.getComment()));
			row.appendChild(new Label(item.getId()));

			if(!item.getType().equals(ReviewResult.Type.WAITING))
				checkbox.setDisabled(true);
			
			reviews.getRows().appendChild(row);
		}

		toolbar.getNew().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				Row row = new Row();

				Listbox results = Components.fullSpanSelect();
				results.appendChild(new Listitem(ReviewResult.Type.WAITING.display(),ReviewResult.Type.WAITING.name()));
				results.setSelectedIndex(0);

				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.mandatoryDatebox());
				row.appendChild(Components.newSelect(personService.findAll(),true));
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
				Iterator<Component> iterator = reviews.getRows().getChildren().iterator();
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
