/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.budget;

import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tabpanel;

import com.kratonsolution.belian.accounting.dm.Budget;
import com.kratonsolution.belian.accounting.dm.BudgetItem;
import com.kratonsolution.belian.accounting.svc.BudgetItemService;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BudgetItemPanel extends Tabpanel
{
	private BudgetItemService service = Springs.get(BudgetItemService.class);
	
	private Grid grid = new Grid();
	
	public BudgetItemPanel(Budget budget)
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
		grid.getColumns().appendChild(new Column("Seq",null,"50px"));
		grid.getColumns().appendChild(new Column("Budget",null,"125px"));
		grid.getColumns().appendChild(new Column("Purpose",null,"150px"));
		grid.getColumns().appendChild(new Column("justification",null,"150px"));
		grid.getColumns().appendChild(new Column(null,null,"0px"));
		grid.getColumns().getChildren().get(5).setVisible(false);
		grid.setSpan("3");

		for(BudgetItem item:budget.getItems())
		{
			Row row = new Row();
			row.appendChild(Components.readOnlyCheckbox());
			row.appendChild(Components.readOnlyDoubleBox(item.getSequence()));
			row.appendChild(Components.doubleBox(item.getAmount().doubleValue()));
			row.appendChild(Components.textBox(item.getPurpose()));
			row.appendChild(Components.textBox(item.getJustification()));
			row.appendChild(new Label(item.getId()));
			
			grid.getRows().appendChild(row);
		}
		appendChild(grid);
	}
}
