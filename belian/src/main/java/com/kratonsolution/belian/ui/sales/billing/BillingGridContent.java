/**
 * 
 */
package com.kratonsolution.belian.ui.sales.billing;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.event.PagingEvent;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.sales.dm.Billable;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.component.SearchBox;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class BillingGridContent extends GridContent
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	public BillingGridContent()
	{
		super();
		
		appendChild(gridToolbar);
		appendChild(new SearchBox(new EventListener<InputEvent>()
		{
			@Override
			public void onEvent(InputEvent event) throws Exception
			{
				ListModel<Billable> model = grid.getModel();
				if(model instanceof BillingModel)
				{
					
					BillingModel cm = (BillingModel)model;
					cm.search(event.getValue());
					grid.setModel(cm);
				}
			}
		}));
		
		appendChild(grid);
		
		initToolbar();
		initGrid();
	}
	
	protected void initToolbar()
	{
		gridToolbar.getRefresh().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				grid.getPagingChild().setActivePage(0);
				refresh(new BillingModel(utils.getRowPerPage()));
			}
		});
		
		gridToolbar.removeChild(gridToolbar.getNew());
		gridToolbar.removeChild(gridToolbar.getDelete());
		gridToolbar.removeChild(gridToolbar.getSelect());
	}
	
	protected void initGrid()
	{
		final BillingModel model = new BillingModel(utils.getRowPerPage());

		grid.setHeight("80%");
		grid.setEmptyMessage("No billing data exist.");
		grid.setModel(model);
		grid.setRowRenderer(new BillingRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(utils.getRowPerPage());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column("Number",null,"125px"));
		grid.getColumns().appendChild(new Column("Customer",null,"150px"));
		grid.getColumns().appendChild(new Column("Amount",null,"100px"));
		grid.getColumns().appendChild(new Column("Currency",null,"100px"));
		grid.getColumns().appendChild(new Column("Status",null,"85px"));
		grid.getColumns().appendChild(new Column("Type",null,"125px"));
		grid.getColumns().appendChild(new Column(null,null,"0px"));
		grid.getColumns().getChildren().get(6).setVisible(false);
		grid.addEventListener("onPaging",new EventListener<PagingEvent>()
		{
			@Override
			public void onEvent(PagingEvent event) throws Exception
			{
				model.next(event.getActivePage(), utils.getRowPerPage());
				grid.setModel(model);
				refresh(model);
			}
		});
		
		refresh(new BillingModel(utils.getRowPerPage()));
	}
}