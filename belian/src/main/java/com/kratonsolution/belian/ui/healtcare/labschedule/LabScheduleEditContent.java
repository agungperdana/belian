/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.labschedule;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import com.kratonsolution.belian.healtcare.dm.LaboratoryBilling;
import com.kratonsolution.belian.healtcare.dm.LaboratoryBilling.Status;
import com.kratonsolution.belian.healtcare.dm.LaboratoryBillingItem;
import com.kratonsolution.belian.healtcare.svc.LaboratoryBillingService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Dates;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LabScheduleEditContent extends FormContent
{	
	private LaboratoryBillingService service = Springs.get(LaboratoryBillingService.class);
	
	private Row row;

	public LabScheduleEditContent(Row row)
	{
		super();
		this.row = row;
		initToolbar();
		initForm();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				LabScheduleWindow window = (LabScheduleWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().setLabel("Handled");
		toolbar.getSave().setImage("/icons/handled.png");
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				LaboratoryBilling billing = service.findOne(RowUtils.string(row, 6));
				if(billing.getStatus().equals(Status.REGISTERED))
				{
					billing.setStatus(Status.HANDLED);
					service.edit(billing);
				
					Clients.showNotification("Document Successfuly saved.");
					
					LabScheduleWindow window = (LabScheduleWindow)getParent();
					window.removeEditForm();
					window.insertGrid();
				}
			}
		});
	}

	@Override
	public void initForm()
	{
		LaboratoryBilling billing = service.findOne(RowUtils.string(row, 6));
		if(billing != null)
		{
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			grid.setSpan("1");
			grid.getRows().appendChild(RowUtils.row("Company", billing.getOrganization().getName()));
			grid.getRows().appendChild(RowUtils.row("Number", billing.getNumber()));
			grid.getRows().appendChild(RowUtils.row("Date", Dates.format(billing.getDate())));
			grid.getRows().appendChild(RowUtils.row("Patient", billing.getCustomer().getName()));
			grid.getRows().appendChild(RowUtils.row("Doctor/Initiator", billing.getSales().getName()));
			grid.getRows().appendChild(RowUtils.row("Payment Status", billing.isPaid()?"Paid":"Unpaid"));
			grid.getRows().appendChild(RowUtils.row("Handling Status", billing.getStatus().name()));
			
			Grid items = new Grid();
			items.setWidth("100%");
			items.setEmptyMessage("no laboratory detail available.");
			items.appendChild(new Columns());
			items.appendChild(new Rows());
			items.getColumns().appendChild(new Column("Service",null,"200px"));
			items.getColumns().appendChild(new Column("Quantity",null,"85px"));
			items.getColumns().appendChild(new Column("Note",null,"165px"));
			items.setSpan("0");
			
			for(LaboratoryBillingItem item:billing.getItems())
			{
				Row row = new Row();
				row.appendChild(new Label(item.getResource()));
				row.appendChild(new Label(item.getQuantity().intValue()+""));
				row.appendChild(new Label(item.getNote()));
				
				items.getRows().appendChild(row);
			}
			
			appendChild(items);
		}
	}
}
