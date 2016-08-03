/**
 * 
 */
package com.kratonsolution.belian.ui.sales.cashier;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.event.PagingEvent;

import com.kratonsolution.belian.sales.dm.Billable;
import com.kratonsolution.belian.sales.srv.CashierShiftService;
import com.kratonsolution.belian.ui.GridContent;
import com.kratonsolution.belian.ui.PrintWindow;
import com.kratonsolution.belian.ui.component.SearchBox;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class CashierGridContent extends GridContent
{
	public CashierGridContent()
	{
		super();
		
		appendChild(gridToolbar);
		appendChild(new SearchBox(new SearchHandler()));
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
				refresh(new CashierModel(utils.getRowPerPage(),utils.getOrganization().getId()));
			}
		});
		
		Toolbarbutton close = new Toolbarbutton(lang.get("generic.grid.column.cashierclose"),"/icons/cashier-shift.png");
		close.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				CashierShiftService service = Springs.get(CashierShiftService.class);
				if(service != null)
				{
					String id = service.close();
					PrintWindow window = new PrintWindow("/cashiershiftprint.htm?id="+id,true);
					window.setPage(getPage());
					window.doModal();
				}
				
				Flow.next(getParent(),new CashierShiftFormContent());
			}
		});
		
		gridToolbar.appendChild(close);
		gridToolbar.removeChild(gridToolbar.getNew());
		gridToolbar.removeChild(gridToolbar.getDelete());
		gridToolbar.removeChild(gridToolbar.getSelect());
		gridToolbar.removeChild(gridToolbar.getDeselect());		
	}
	
	protected void initGrid()
	{
		final CashierModel model = new CashierModel(utils.getRowPerPage(),utils.getOrganization().getId());

		grid.setHeight("80%");
		grid.setEmptyMessage(lang.get("message.grid.empty"));
		grid.setModel(model);
		grid.setRowRenderer(new CashierRowRenderer());
		grid.setPagingPosition("both");
		grid.setMold("paging");
		grid.setPageSize(utils.getRowPerPage());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(lang.get("generic.grid.column.number"),null,"150px"));
		grid.getColumns().appendChild(new Column(lang.get("generic.grid.column.customer"),null,"120px"));
		grid.getColumns().appendChild(new Column(lang.get("generic.grid.column.seq"),null,"50px"));
		grid.getColumns().appendChild(new Column(lang.get("generic.grid.column.amount"),null,"100px"));
		grid.getColumns().appendChild(new Column(lang.get("generic.grid.column.currency"),null,"100px"));
		grid.getColumns().appendChild(new Column(lang.get("generic.grid.column.dept"),null,"125px"));
		grid.getColumns().appendChild(new Column(null,null,"0px"));
		grid.getColumns().getLastChild().setVisible(false);
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
	
	private class SearchHandler implements EventListener<InputEvent>
	{

		@Override
		public void onEvent(InputEvent event) throws Exception
		{
			ListModel<Billable> model = grid.getModel();
			if(model instanceof CashierModel)
			{
				
				CashierModel cm = (CashierModel)model;
				cm.search(event.getValue());
				grid.setModel(cm);
			}
		}
	}
}