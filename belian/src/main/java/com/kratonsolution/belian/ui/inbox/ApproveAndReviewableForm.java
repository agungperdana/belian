/**
 * 
 */
package com.kratonsolution.belian.ui.inbox;

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
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Vlayout;

import com.kratonsolution.belian.global.dm.ApproveAndReviewableItem;
import com.kratonsolution.belian.global.dm.Review;
import com.kratonsolution.belian.global.dm.Roled;
import com.kratonsolution.belian.global.dm.RoledType;
import com.kratonsolution.belian.global.dm.StatusType;
import com.kratonsolution.belian.global.svc.RoledService;
import com.kratonsolution.belian.ui.Removeable;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Dates;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ApproveAndReviewableForm extends Vlayout implements Removeable
{	
	private RoledService service = Springs.get(RoledService.class);
	
	private Listbox statuses = Components.newSelect();
	
	private Textbox note = Components.stdTextBox(null,false);
	
	private Tabbox tabbox = new Tabbox();
	
	public ApproveAndReviewableForm(Roled roled)
	{
		setWidth("100%");
		setHeight("100%");
	
		initToolbar(roled);
		initGrid(roled);
		initTabbox(roled);
	}
	
	private void initToolbar(Roled roled)
	{
		Toolbar toolbar = new Toolbar();
		toolbar.setWidth("100%");
		
		if(roled != null && roled.getType().equals(RoledType.Approver))
		{
			Toolbarbutton approved = new Toolbarbutton("Approve","/icons/approved.png");
			approved.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					service.done(roled,StatusType.Approved,note.getText());
					Flow.next(getParent().getParent().getParent(), new InboxContent());
				}
			});
			
			Toolbarbutton rejected = new Toolbarbutton("Reject","/icons/rejected.png");
			rejected.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					service.done(roled,StatusType.Rejected,note.getText());
					Flow.next(getParent().getParent().getParent(), new InboxContent());
				}
			});
			
			toolbar.appendChild(approved);
			toolbar.appendChild(rejected);
		}
		if(roled != null && roled.getType().equals(RoledType.Reviewer))
		{
			Toolbarbutton approved = new Toolbarbutton("Reviewed","/icons/approved.png");
			approved.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					service.done(roled,StatusType.Reviewed,note.getText());
					Flow.next(getParent().getParent().getParent(), new InboxContent());
				}
			});
			
			toolbar.appendChild(approved);
		}
		
		appendChild(toolbar);
	}
	
	private void initGrid(Roled roled)
	{
		Grid grid = new Grid();
		grid.setWidth("100%");
		grid.appendChild(new Rows());
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		grid.setSpan("1");

		grid.getRows().appendChild(RowUtils.row("Number",roled.getDocument().getNumber()));
		grid.getRows().appendChild(RowUtils.row("Date", Dates.format(roled.getDocument().getDate())));
		grid.getRows().appendChild(RowUtils.row("Company", roled.getDocument().getOrganization().getName()));
		grid.getRows().appendChild(RowUtils.row("Result",note));
		
		appendChild(grid);
	}
	
	private void initTabbox(Roled roled)
	{
		tabbox.setHflex("1");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab("Item(s)"));
		tabbox.getTabs().appendChild(new Tab("Review(s)"));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		appendChild(tabbox);
		
		initItems(roled);
		initReviews(roled);
	}
	
	private void initItems(Roled roled)
	{
		Grid items = new Grid();
		items.appendChild(new Columns());
		items.appendChild(new Rows());
		items.setWidth("100%");
		items.setEmptyMessage("No items yet");
		items.getColumns().appendChild(new Column("Resource",null,"150px"));
		items.getColumns().appendChild(new Column("Quan/Amount",null,"100px"));
		items.getColumns().appendChild(new Column("UoM",null,"100px"));
		items.getColumns().appendChild(new Column("Note",null,"150px"));
		items.setSpan("0");
		
		for(ApproveAndReviewableItem item:roled.getDocument().getItems())
		{
			Row row = new Row();
			row.appendChild(new Label(item.getResource()));
			row.appendChild(Components.label(item.getQuantity()));
			row.appendChild(new Label(item.getUom()));
			row.appendChild(new Label(item.getNote()));
			
			items.getRows().appendChild(row);
		}
		
		tabbox.getTabpanels().getChildren().get(0).appendChild(items);
	}
	
	private void initReviews(Roled roled)
	{
		Grid items = new Grid();
		items.appendChild(new Columns());
		items.appendChild(new Rows());
		items.setWidth("100%");
		items.getColumns().appendChild(new Column("Date",null,"85px"));
		items.getColumns().appendChild(new Column("Reviewer",null,"150px"));
		items.getColumns().appendChild(new Column("Comment",null,"200px"));
		items.setSpan("2");
		items.setEmptyMessage("No reviews yet");
		
		for(Review item:roled.getDocument().getReviews())
		{
			Row row = new Row();
			row.appendChild(new Label(Dates.format(item.getDate())));
			row.appendChild(new Label(item.getParty().getName()));
			row.appendChild(new Label(item.getResult()));
			
			items.getRows().appendChild(row);
		}
		
		tabbox.getTabpanels().getChildren().get(1).appendChild(items);
	}
}
