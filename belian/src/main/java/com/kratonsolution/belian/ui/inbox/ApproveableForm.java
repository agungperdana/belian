/**
 * 
 */
package com.kratonsolution.belian.ui.inbox;

import java.util.ArrayList;
import java.util.Collection;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.global.dm.Approveable;
import com.kratonsolution.belian.global.dm.ApproveableItem;
import com.kratonsolution.belian.global.dm.ApproverStatus;
import com.kratonsolution.belian.global.svc.ApproveableService;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Dates;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ApproveableForm extends Vlayout
{	
	private Approveable approveable;
	
	private Listbox statuses = Components.newSelect();
	
	private Collection<ApproveableListener> listeners = new ArrayList<ApproveableListener>();
	
	public ApproveableForm(Approveable approveable)
	{
		this.approveable = approveable;
		
		setWidth("100%");
		setHeight("100%");
	
		initToolbar();
		initGrid();
	}
	
	private void initToolbar()
	{
		Toolbar toolbar = new Toolbar();
		toolbar.setWidth("100%");
		
		Toolbarbutton approved = new Toolbarbutton("Approve","/icons/approved.png");
		approved.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				approveable.setApproverStatus(ApproverStatus.ACCEPTED);
				
				ApproveableService service = Springs.get(ApproveableService.class);
				service.edit(approveable);
				
				Clients.showNotification("Data Successfully updated.");
				
				for(ApproveableListener listener:listeners)
					listener.fireApproveableDataUpdated(approveable);
			}
		});
		
		Toolbarbutton rejected = new Toolbarbutton("Reject","/icons/rejected.png");
		rejected.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				approveable.setApproverStatus(ApproverStatus.REJECTED);
				
				ApproveableService service = Springs.get(ApproveableService.class);
				service.edit(approveable);
				
				Clients.showNotification("Data Successfully updated.");
				
				for(ApproveableListener listener:listeners)
					listener.fireApproveableDataUpdated(approveable);
			}
		});
		
		toolbar.appendChild(approved);
		toolbar.appendChild(rejected);
		appendChild(toolbar);
	}
	
	private void initGrid()
	{
		Grid grid = new Grid();
		grid.setWidth("100%");
		grid.appendChild(new Rows());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");
		
		appendChild(grid);
		
		if(approveable != null)
		{
			grid.getRows().appendChild(RowUtils.row("Date", Dates.format(approveable.getDate())));
			grid.getRows().appendChild(RowUtils.row("Company", approveable.getOrganization().getName()));
			grid.getRows().appendChild(RowUtils.row("Request By", approveable.getRequester().getName()));
			grid.getRows().appendChild(RowUtils.row("Status",approveable.getApproverStatus().name()));
			
			Grid items = new Grid();
			items.appendChild(new Columns());
			items.appendChild(new Rows());
			items.setWidth("100%");
			items.getColumns().appendChild(new Column("Product",null,"150px"));
			items.getColumns().appendChild(new Column("Quantity",null,"100px"));
			items.getColumns().appendChild(new Column("UoM",null,"100px"));
			items.getColumns().appendChild(new Column("Note",null,"150px"));
			items.setSpan("0");
			
			for(ApproveableItem item:approveable.getItems())
			{
				Row row = new Row();
				row.appendChild(new Label(item.getProduct().getName()));
				row.appendChild(Components.label(item.getQuantity()));
				row.appendChild(new Label(item.getProduct().getUom().getName()));
				row.appendChild(new Label(item.getNote()));
				
				items.getRows().appendChild(row);
			}
			
			appendChild(items);
		}
	}
	
	public void addListener(ApproveableListener listener)
	{
		listeners.add(listener);
	}
}
