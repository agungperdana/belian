/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.labschedule;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.healtcare.dm.LabHandlingStatus;
import com.kratonsolution.belian.healtcare.dm.LaboratorySalesItem;
import com.kratonsolution.belian.healtcare.dm.LaboratorySales;
import com.kratonsolution.belian.healtcare.svc.LaboratorySalesService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class LabScheduleEditContent extends FormContent
{	
	private LaboratorySalesService service = Springs.get(LaboratorySalesService.class);
	
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
				LaboratorySales laboratory = service.findOne(RowUtils.string(row, 4));
				if(laboratory != null && laboratory.getStatus().equals(LabHandlingStatus.Registered))
				{
					laboratory.setHandlingStatus(LabHandlingStatus.Handled);
					service.handle(laboratory);
				}
				
				LabScheduleWindow window = (LabScheduleWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		LaboratorySales laboratory = service.findOne(RowUtils.string(row, 4));
		if(laboratory != null)
		{
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			grid.setSpan("1");
			grid.getRows().appendChild(RowUtils.row("Company", laboratory.getOrganization().getName()));
			grid.getRows().appendChild(RowUtils.row("Number", laboratory.getNumber()));
			grid.getRows().appendChild(RowUtils.row("Date", DateTimes.format(laboratory.getDate())));
			grid.getRows().appendChild(RowUtils.row("Patient", laboratory.getCustomer().getName()));
			grid.getRows().appendChild(RowUtils.row("Doctor/Initiator", laboratory.getSales().getName()));
			grid.getRows().appendChild(RowUtils.row("Payment Status", laboratory.isPaid()?"Paid":"Unpaid"));
			grid.getRows().appendChild(RowUtils.row("Handling Status", laboratory.getStatus().name()));
			
			Grid items = new Grid();
			items.setWidth("100%");
			items.setEmptyMessage("no laboratory detail available.");
			items.appendChild(new Columns());
			items.appendChild(new Rows());
			items.getColumns().appendChild(new Column("Service",null,"200px"));
			items.getColumns().appendChild(new Column("Quantity",null,"100px"));
			items.getColumns().appendChild(new Column("UoM",null,"100px"));
			items.getColumns().appendChild(new Column("Note",null,"165px"));
			items.setSpan("0");
			
			for(LaboratorySalesItem item:laboratory.getItems())
			{
				Row row = new Row();
				row.appendChild(new Label(item.getResource()));
				row.appendChild(new Label(item.getQuantity().toString()));
				row.appendChild(new Label(item.getService().getUom().getName()));
				row.appendChild(new Label(item.getNote()));
				
				items.getRows().appendChild(row);
			}
			
			appendChild(items);
		}
	}
}
