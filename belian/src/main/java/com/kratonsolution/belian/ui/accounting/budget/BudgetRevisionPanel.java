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
import com.kratonsolution.belian.accounting.dm.BudgetRevision;
import com.kratonsolution.belian.common.Dates;
import com.kratonsolution.belian.ui.util.Components;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BudgetRevisionPanel extends Tabpanel
{
	private Grid grid = new Grid();
	
	public BudgetRevisionPanel(Budget budget)
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
		grid.setEmptyMessage("No budget revision exist.");
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column("Seq",null,"50px"));
		grid.getColumns().appendChild(new Column("Date",null,"125px"));
		grid.getColumns().appendChild(new Column("Comment",null,"150px"));
		grid.getColumns().appendChild(new Column(null,null,"0px"));
		grid.getColumns().getChildren().get(4).setVisible(false);
		grid.setSpan("3");

		for(BudgetRevision item:budget.getRevisions())
		{
			Row row = new Row();
			row.appendChild(Components.readOnlyCheckbox());
			row.appendChild(Components.readOnlyDoubleBox(item.getSequence()));
			row.appendChild(Components.readOnlyTextBox(Dates.format(item.getDate())));
			row.appendChild(Components.textBox(item.getComment()));
			row.appendChild(new Label(item.getId()));
			
			grid.getRows().appendChild(row);
		}
		appendChild(grid);
	}
}
