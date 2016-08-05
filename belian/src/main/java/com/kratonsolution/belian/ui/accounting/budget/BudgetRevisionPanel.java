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
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BudgetRevisionPanel extends Tabpanel
{
	private Language lang = Springs.get(Language.class);
	
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
		grid.setEmptyMessage(lang.get("message.grid.empty"));
		grid.getColumns().appendChild(new Column(null,null,"25px"));
		grid.getColumns().appendChild(new Column(lang.get("budget.grid.column.seq"),null,"50px"));
		grid.getColumns().appendChild(new Column(lang.get("budget.grid.column.date"),null,"125px"));
		grid.getColumns().appendChild(new Column(lang.get("budget.grid.column.comment"),null,"150px"));
		grid.getColumns().appendChild(new Column());
		grid.getColumns().getLastChild().setVisible(false);
		grid.setSpan("3");

		for(BudgetRevision item:budget.getRevisions())
		{
			Row row = new Row();
			row.appendChild(Components.readOnlyCheckbox());
			row.appendChild(Components.readOnlyDoubleBox(item.getSequence()));
			row.appendChild(Components.readOnlyTextBox(DateTimes.format(item.getDate())));
			row.appendChild(Components.textBox(item.getComment()));
			row.appendChild(new Label(item.getId()));
			
			grid.getRows().appendChild(row);
		}
		appendChild(grid);
	}
}
