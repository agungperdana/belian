/**
 * 
 */
package com.kratonsolution.belian.ui.tools.notification;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.global.dm.Acknowledgement;
import com.kratonsolution.belian.global.dm.AcknowledgementItem;
import com.kratonsolution.belian.global.dm.ApproverStatus;
import com.kratonsolution.belian.global.svc.AcknowledgementService;
import com.kratonsolution.belian.orders.dm.RoleType;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class RequestAcknowledgementForm extends AbstractForm
{
	private AcknowledgementService repository = Springs.get(AcknowledgementService.class);
	
	private Tabbox tabbox = new Tabbox();
	
	public RequestAcknowledgementForm(Acknowledgement acknowledgement)
	{
		initToolbar(acknowledgement);
		initForm(acknowledgement);
		initTabbox(acknowledgement);
	}
	
	public void initToolbar(Acknowledgement acknowledgement)
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				getParent().removeChild(RequestAcknowledgementForm.this);
			}
		});
		
		toolbar.removeChild(toolbar.getSave());
		
		if(acknowledgement.getType().equals(RoleType.APPROVER))
		{
			toolbar.appendChild(toolbar.getApprove());
			toolbar.appendChild(toolbar.getPending());
			toolbar.appendChild(toolbar.getReject());
			
			toolbar.getApprove().addEventListener(Events.ON_CLICK, new EventListener<Event>()
			{
				@Override
				public void onEvent(Event arg0) throws Exception
				{
					acknowledgement.setApproverStatus(ApproverStatus.ACCEPTED);
					repository.edit(acknowledgement);
					toolbar.getApprove().setDisabled(true);
				}
			});
			
			toolbar.getPending().addEventListener(Events.ON_CLICK, new EventListener<Event>()
			{
				@Override
				public void onEvent(Event arg0) throws Exception
				{
					acknowledgement.setApproverStatus(ApproverStatus.PENDING);
					repository.edit(acknowledgement);
					toolbar.getPending().setDisabled(true);
				}
			});
			
			toolbar.getReject().addEventListener(Events.ON_CLICK, new EventListener<Event>()
			{
				@Override
				public void onEvent(Event arg0) throws Exception
				{
					acknowledgement.setApproverStatus(ApproverStatus.REJECTED);
					repository.edit(acknowledgement);
					toolbar.getReject().setDisabled(true);
				}
			});
		}
		else
		{
			toolbar.appendChild(toolbar.getReview());
			toolbar.getReview().addEventListener(Events.ON_CLICK, new EventListener<Event>()
			{
				@Override
				public void onEvent(Event arg0) throws Exception
				{
					acknowledgement.setApproverStatus(ApproverStatus.REVIEWED);
					repository.edit(acknowledgement);
					toolbar.getReview().setDisabled(true);
				}
			});
		}
	}
	
	@Override
	public void initToolbar(){}

	@Override
	public void initForm(){}
	
	private void initForm(Acknowledgement acknowledgement)
	{
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		grid.getRows().appendChild(RowUtils.row(lang.get("order.grid.column.entrydate"),DateTimes.format(acknowledgement.getDate())));
		grid.getRows().appendChild(RowUtils.row(lang.get("order.grid.column.organization"),acknowledgement.getOrigin()));
		grid.getRows().appendChild(RowUtils.row(lang.get("order.grid.column.supplier"),acknowledgement.getResponding()));
		grid.getRows().appendChild(RowUtils.row(lang.get("order.grid.column.status"),acknowledgement.getApproverStatus().display(utils.getLanguage())));
		grid.getRows().appendChild(RowUtils.row(lang.get("order.grid.column.creator"),acknowledgement.getPerson().getValue()));
	}
	
	private void initTabbox(Acknowledgement acknowledgement)
	{
		tabbox.setHflex("1");
		tabbox.appendChild(new Tabs());
		tabbox.appendChild(new Tabpanels());
		tabbox.getTabs().appendChild(new Tab(lang.get("order.grid.column.items")));
		tabbox.getTabpanels().appendChild(new Tabpanel());
		
		Grid items = new Grid();
		items.setWidth("100%");
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.note"),null,"250px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.quantity"),null,"125px"));
		items.getColumns().appendChild(new Column(lang.get("order.items.grid.column.maxallowed"),null,"125px"));
		items.setSpan("0");
		
		for(AcknowledgementItem item:acknowledgement.getDetails())
		{
			Row row = new Row();
			row.appendChild(new Label(item.getItemDescription()));
			row.appendChild(new Label(item.getOrderQuan()));
			row.appendChild(new Label(item.getMaxPrice()));
			
			items.getRows().appendChild(row);
		}
		
		tabbox.getTabpanels().getFirstChild().appendChild(items);
		
		appendChild(tabbox);
	}
}
