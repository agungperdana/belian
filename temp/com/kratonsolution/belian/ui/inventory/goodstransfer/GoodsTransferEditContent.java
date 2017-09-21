/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.goodstransfer;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.GoodsTransfer;
import com.kratonsolution.belian.inventory.dm.GoodsTransferItem;
import com.kratonsolution.belian.inventory.dm.TransferOrderRequestItemRepository;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.inventory.svc.GoodsTransferService;
import com.kratonsolution.belian.inventory.svc.TransferOrderRequestService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GoodsTransferEditContent extends FormContent
{	
	private GoodsTransferService service = Springs.get(GoodsTransferService.class);

	private SessionUtils utils = Springs.get(SessionUtils.class);

	private TransferOrderRequestService requestService = Springs.get(TransferOrderRequestService.class);

	private TransferOrderRequestItemRepository itemRepository = Springs.get(TransferOrderRequestItemRepository.class);

	private FacilityService facilityService = Springs.get(FacilityService.class);

	private Datebox date = Components.currentDatebox();

	private Textbox number = new Textbox();

	private Listbox companyfrom = Components.newSelect();

	private Listbox companyto = Components.newSelect();

	private Listbox facilityfrom = Components.newSelect();

	private Listbox facilityto = Components.newSelect();

	private Listbox requests = Components.newSelect();

	private Listbox users = Components.newSelect();

	private Grid items = new Grid();

	private Row row;

	public GoodsTransferEditContent(Row row)
	{
		super();
		this.row = row;
		
		initToolbar();
		initForm();
		initItems();
	}

	@Override
	public void initToolbar()
	{
		toolbar.getCancel().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				GoodsTransferWindow window = (GoodsTransferWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				GoodsTransferWindow window = (GoodsTransferWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		GoodsTransfer transfer = service.findOne(RowUtils.string(row, 8));
		if(transfer != null)
		{
			number.setReadonly(true);
			number.setWidth("250px");
			number.setText(transfer.getNumber());
			
			date.setValue(transfer.getDate());
			companyfrom.appendChild(new Listitem(transfer.getSource().getLabel(),transfer.getSource().getId()));
			Components.setDefault(companyfrom);
			companyto.appendChild(new Listitem(transfer.getDestination().getLabel(),transfer.getDestination().getId()));
			Components.setDefault(companyto);
			facilityfrom.appendChild(new Listitem(transfer.getFacilityFrom().getLabel(), transfer.getFacilityTo().getId()));
			Components.setDefault(facilityfrom);
			facilityto.appendChild(new Listitem(transfer.getFacilityFrom().getLabel(), transfer.getFacilityTo().getId()));
			Components.setDefault(facilityto);
			requests.appendChild(new Listitem(transfer.getRequest().getLabel(),transfer.getRequest().getId()));
			Components.setDefault(requests);
			
			if(transfer.getTransferedBy() != null)
			{
				users.appendChild(new Listitem(transfer.getTransferedBy().getLabel(), transfer.getTransferedBy().getId()));
				Components.setDefault(users);
			}
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			
			Row row1 = new Row();
			row1.appendChild(new Label("Date"));
			row1.appendChild(date);
			
			Row row2 = new Row();
			row2.appendChild(new Label("Number"));
			row2.appendChild(number);
			
			Row row3 = new Row();
			row3.appendChild(new Label("Source Company"));
			row3.appendChild(companyfrom);

			Row row4 = new Row();
			row4.appendChild(new Label("Source Facility"));
			row4.appendChild(facilityfrom);
			
			Row row5 = new Row();
			row5.appendChild(new Label("Destination Company"));
			row5.appendChild(companyto);

			Row row6 = new Row();
			row6.appendChild(new Label("Destination Facility"));
			row6.appendChild(facilityto);
			
			Row row7 = new Row();
			row7.appendChild(new Label("Request Number"));
			row7.appendChild(requests);
			
			Row row8 = new Row();
			row8.appendChild(new Label("Transfered By"));
			row8.appendChild(users);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
			rows.appendChild(row5);
			rows.appendChild(row6);
			rows.appendChild(row7);
			rows.appendChild(row8);
		}
	}
	
	private void initItems()
	{
		items.setWidth("100%");
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column("Product",null, "150px"));
		items.getColumns().appendChild(new Column("Quantity",null, "150px"));
		items.getColumns().appendChild(new Column("Note",null, "150px"));
		items.setSpan("0");
		
		GoodsTransfer transfer = service.findOne(RowUtils.string(row, 8));
		if(transfer != null)
		{
			for(GoodsTransferItem item:transfer.getItems())
			{
				Row row = new Row();
				row.appendChild(new Label(item.getProduct().getName()));
				row.appendChild(Components.label(item.getQuantity()));
				row.appendChild(new Label(item.getNote()));
				
				items.getRows().appendChild(row);
			}
		}
		
		appendChild(items);
	}
}
