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

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.Budget;
import com.kratonsolution.belian.accounting.dm.BudgetItem;
import com.kratonsolution.belian.accounting.dm.BudgetType;
import com.kratonsolution.belian.accounting.svc.BudgetService;
import com.kratonsolution.belian.accounting.svc.BudgetTypeService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.util.Components;
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

	private Datebox start = new Datebox(new Date());

	private Datebox end = new Datebox();

	private Listbox types = Components.newSelect();

	private Textbox description = new Textbox();

	private Tabbox tabbox = new Tabbox();
	
	private Grid budgetItems = new Grid();
	
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
		tabbox.getTabpanels().appendChild(new Tabpanel());

		appendChild(tabbox);
	
		initItems();
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
						
						if(Strings.isNullOrEmpty(RowUtils.string(comp, 5)))
							item.setId(UUID.randomUUID().toString());
						else
							item.setId(RowUtils.string(comp, 5));
						
						budget.getItems().add(item);
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
		row4.appendChild(new Label("Description"));
		row4.appendChild(description);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
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
				row.appendChild(new Label());
				
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
}
