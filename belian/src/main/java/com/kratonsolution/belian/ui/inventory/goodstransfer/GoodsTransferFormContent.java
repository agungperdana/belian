/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.goodstransfer;

import java.sql.Date;

import org.zkoss.zk.ui.Component;
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
import com.kratonsolution.belian.inventory.dm.FacilityOrganization;
import com.kratonsolution.belian.inventory.dm.GoodsTransfer;
import com.kratonsolution.belian.inventory.dm.GoodsTransferItem;
import com.kratonsolution.belian.inventory.dm.TransferOrderRequest;
import com.kratonsolution.belian.inventory.dm.TransferOrderRequestItem;
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
public class GoodsTransferFormContent extends FormContent
{	
	private GoodsTransferService service = Springs.get(GoodsTransferService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private TransferOrderRequestService requestService = Springs.get(TransferOrderRequestService.class);
	
	private TransferOrderRequestItemRepository itemRepository = Springs.get(TransferOrderRequestItemRepository.class);
	
	private FacilityService facilityService = Springs.get(FacilityService.class);
	
	private Datebox date = Components.currentDatebox();
	
	private Textbox number = new Textbox();
	
	private Listbox companyfrom = Components.newSelect(utils.getOrganization());
	
	private Listbox companyto = Components.newSelect();
	
	private Listbox facilityfrom = Components.newSelect(facilityService.findAllActive(),true);
	
	private Listbox facilityto = Components.newSelect();

	private Listbox requests = Components.newSelect(requestService.findAllIncomplete(),true);
	
	private Listbox users = Components.newSelect(utils.getUser().getPerson());
	
	private Grid items = new Grid();
	
	public GoodsTransferFormContent()
	{
		super();
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
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				GoodsTransfer transfer = new GoodsTransfer();
				transfer.setDate(new Date(date.getValue().getTime()));
				transfer.setRequest(requestService.findOne(Components.string(requests)));
				transfer.setDestination(transfer.getRequest().getOrganization());
				transfer.setFacilityFrom(facilityService.findOne(Components.string(facilityfrom)));
				transfer.setFacilityTo(facilityService.findOne(Components.string(facilityto)));
				transfer.setNumber(number.getText());
				transfer.setSource(utils.getOrganization());
				transfer.setTransferedBy(utils.getUser().getPerson());
				
				for(Component com:items.getRows().getChildren())
				{
					Row row = (Row)com;
					
					GoodsTransferItem item = new GoodsTransferItem();
					item.setGoodsTransfer(transfer);
					item.setNote(RowUtils.string(row, 2));
					item.setQuantity(RowUtils.decimal(row, 1));
					item.setRequestedItem(itemRepository.findOne(RowUtils.string(row, 3)));
					item.setProduct(item.getRequestedItem().getProduct());
					
					transfer.getItems().add(item);
				}
				
				service.add(transfer);
				
				GoodsTransferWindow window = (GoodsTransferWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		number.setReadonly(true);
		number.setWidth("250px");
		number.setText(GoodsTransfer.NCODE+System.currentTimeMillis());
		
		extractRequestInfo();
		requests.addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				extractRequestInfo();
				initItemRow();
			}
		});
		
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
	
	private void initItems()
	{
		items.setWidth("100%");
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column("Product",null, "150px"));
		items.getColumns().appendChild(new Column("Quantity",null, "150px"));
		items.getColumns().appendChild(new Column("Note",null, "150px"));
		items.getColumns().appendChild(new Column(null,null, "1px"));
		items.getColumns().getChildren().get(3).setVisible(false);
		items.setSpan("0");
		
		initItemRow();
		
		appendChild(items);
	}
	
	private void extractRequestInfo()
	{
		TransferOrderRequest request = requestService.findOne(Components.string(requests));
		if(request != null)
		{
			companyto.getChildren().clear();
			companyto.appendChild(new Listitem(request.getOrganization().getName(),request.getOrganization().getId()));
			companyto.setSelectedIndex(0);
			
			facilityto.getChildren().clear();
			for(FacilityOrganization organization:request.getOrganization().getFacilitys())
				facilityto.appendChild(new Listitem(organization.getFacility().getLabel(),organization.getFacility().getId()));

			Components.setDefault(facilityto);
		}
	}
	
	private void initItemRow()
	{
		items.getRows().getChildren().clear();
		
		TransferOrderRequest request = requestService.findOne(Components.string(requests));
		if(request != null)
		{
			for(TransferOrderRequestItem item:request.getItems())
			{
				if(!item.isDone())
				{
					Row row = new Row();
					row.appendChild(new Label(item.getResource()));
					row.appendChild(Components.doubleBox(item.getQuantity().subtract(item.getFullfilled()).doubleValue()));
					row.appendChild(Components.textBox(null));
					row.appendChild(new Label(item.getId()));
				
					items.getRows().appendChild(row);
				}
			}
		}
	}
}
