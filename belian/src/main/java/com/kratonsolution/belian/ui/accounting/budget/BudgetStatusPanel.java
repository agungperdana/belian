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
import com.kratonsolution.belian.accounting.dm.BudgetStatus;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BudgetStatusPanel extends Tabpanel
{
	private Language lang = Springs.get(Language.class);
	
	private Grid grid = new Grid();
	
	public BudgetStatusPanel(Budget budget)
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
		grid.getColumns().appendChild(new Column(lang.get("budget.grid.column.date"),null,"125px"));
		grid.getColumns().appendChild(new Column(lang.get("budget.grid.column.type"),null,"125px"));
		grid.getColumns().appendChild(new Column(lang.get("budget.grid.column.note"),null,"200px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().getLastChild().setVisible(false);
		grid.setSpan("3");

		for(BudgetStatus item:budget.getStatuses())
		{
			Row row = new Row();
			row.appendChild(Components.readOnlyCheckbox());
			row.appendChild(Components.fullSpanDatebox(item.getDate()));
			row.appendChild(Components.readOnlyTextBox(item.getType().name()));
			row.appendChild(Components.readOnlyTextBox(item.getDescription()));
			row.appendChild(new Label(item.getId()));
			
			grid.getRows().appendChild(row);
		}

		appendChild(grid);
	}
}
