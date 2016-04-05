/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.budget;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tabpanel;

import com.kratonsolution.belian.accounting.dm.Budget;
import com.kratonsolution.belian.accounting.dm.BudgetRole;
import com.kratonsolution.belian.accounting.dm.BudgetRoleType;
import com.kratonsolution.belian.accounting.svc.BudgetItemService;
import com.kratonsolution.belian.global.svc.EconomicAgentService;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BudgetRolePanel extends Tabpanel
{
	private BudgetItemService service = Springs.get(BudgetItemService.class);
	
	private EconomicAgentService agentService = Springs.get(EconomicAgentService.class);
	
	private Grid grid = new Grid();
	
	private NRCToolbar toolbar = new NRCToolbar(grid);
	
	public BudgetRolePanel(Budget budget)
	{
		setHflex("1");
		setVflex("1");
		setStyle("overflow:auto;");
		
		init(budget);
	}
	
	private void init(Budget budget)
	{
		grid.setWidth("100%");
		grid.appendChild(new Columns());
		grid.appendChild(new Rows());
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column("Party",null,"250px"));
		grid.getColumns().appendChild(new Column("Type",null,"125px"));
		grid.getColumns().appendChild(new Column(null,null,"0px"));
		grid.getColumns().getChildren().get(3).setVisible(false);
		grid.setSpan("2");

		for(BudgetRole item:budget.getRoles())
		{
			Row row = new Row();
			row.appendChild(Components.readOnlyCheckbox());
			row.appendChild(Components.fullSpanSelect(item.getParty()));
			row.appendChild(Components.fullSpanSelect(item.getType().name(),item.getType().name()));
			row.appendChild(new Label(item.getId()));
			
			grid.getRows().appendChild(row);
		}
		
		toolbar.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			int index = service.sequence(budget.getId());
			
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				Listbox types = Components.fullSpanSelect();
				for(BudgetRoleType type:BudgetRoleType.values())
				{
					if(!type.equals(BudgetRoleType.Initiator) && !type.equals(BudgetRoleType.RequestedFor))
					{
						types.appendItem(type.name(),type.name());
						types.setSelectedIndex(0);
					}
				}
				
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(Components.fullSpanSelect(agentService.findAll(),true));
				row.appendChild(types);
				row.appendChild(new Label(UUID.randomUUID().toString()));
				
				grid.getRows().appendChild(row);
				
				index++;
			}
		});
		
		appendChild(toolbar);
		appendChild(grid);
	}
	
	public List<BudgetRole> getItems(Budget budget)
	{
		List<BudgetRole> items = new ArrayList<>();
		
		for(Component com:grid.getRows().getChildren())
		{
			Row row = (Row)com;
			
			BudgetRole item = new BudgetRole();
			item.setBudget(budget);
			item.setParty(agentService.findOne(RowUtils.string(row, 1)));
			item.setType(BudgetRoleType.valueOf(RowUtils.string(row, 2)));
			item.setId(RowUtils.string(row, 3));
			
			items.add(item);
		}
		
		return items;
	}
}
