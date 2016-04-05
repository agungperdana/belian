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
import com.kratonsolution.belian.accounting.dm.BudgetReview;
import com.kratonsolution.belian.ui.util.Components;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BudgetReviewPanel extends Tabpanel
{
	private Grid grid = new Grid();
	
	public BudgetReviewPanel(Budget budget)
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
		grid.getColumns().appendChild(new Column("Date",null,"125px"));
		grid.getColumns().appendChild(new Column("Party",null,"150px"));
		grid.getColumns().appendChild(new Column("Comment",null,"200px"));
		grid.getColumns().appendChild(new Column(null,null,"0px"));
		grid.getColumns().getChildren().get(4).setVisible(false);
		grid.setSpan("3");

		for(BudgetReview item:budget.getReviews())
		{
			Row row = new Row();
			row.appendChild(Components.readOnlyCheckbox());
			row.appendChild(Components.fullSpanDatebox(item.getDate()));
			row.appendChild(Components.readOnlyTextBox(item.getParty().getName()));
			row.appendChild(Components.readOnlyTextBox(item.getResult()));
			row.appendChild(new Label(item.getId()));
			
			grid.getRows().appendChild(row);
		}

		appendChild(grid);
	}
}
