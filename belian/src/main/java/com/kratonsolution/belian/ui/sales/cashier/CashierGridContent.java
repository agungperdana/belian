/**
 * 
 */
package com.kratonsolution.belian.ui.sales.cashier;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.event.PagingEvent;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashierGridContent extends GridContent
{
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	public CashierGridContent()
	{
		super();
		initToolbar();
		initGrid();
	}
	
	protected void initToolbar()
	{
		gridToolbar.setParent(this);
		gridToolbar.getRefresh().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				grid.getPagingChild().setActivePage(0);
				refresh(new CashierModel(utils.getRowPerPage(),utils.getOrganization().getId()));
			}
		});
		
		gridToolbar.removeChild(gridToolbar.getNew());
		gridToolbar.removeChild(gridToolbar.getDelete());
		gridToolbar.removeChild(gridToolbar.getSelect());
		gridToolbar.removeChild(gridToolbar.getDeselect());
		
		gridToolbar.getSearch().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
			}
		});

	}
	
	protected void initGrid()
	{
		final CashierModel model = new CashierModel(utils.getRowPerPage(),utils.getOrganization().getId());

		grid.setParent(this);
		grid.setHeight("80%");
		grid.setEmptyMessage("No billing data exist.");
		grid.setModel(model);
		grid.setRowRenderer(new CashierRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(utils.getRowPerPage());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column("Number",null,"125px"));
		grid.getColumns().appendChild(new Column("Customer",null,"150px"));
		grid.getColumns().appendChild(new Column("Amount",null,"100px"));
		grid.getColumns().appendChild(new Column("Currency",null,"100px"));
		grid.getColumns().appendChild(new Column("Type",null,"125px"));
		grid.getColumns().appendChild(new Column(null,null,"0px"));
		grid.getColumns().getChildren().get(5).setVisible(false);
		grid.addEventListener("onPaging",new EventListener<PagingEvent>()
		{
			@Override
			public void onEvent(PagingEvent event) throws Exception
			{
				model.next(event.getActivePage(), utils.getRowPerPage(),utils.getOrganization().getId());
				grid.setModel(model);
				refresh(model);
			}
		});
		
		refresh(new CashierModel(utils.getRowPerPage(),utils.getOrganization().getId()));
	}
}