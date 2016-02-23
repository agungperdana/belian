/**
 * 
 */
package com.kratonsolution.belian.ui.procurement.purchaseorderrequest;

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

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.svc.PersonService;
import com.kratonsolution.belian.global.dm.ApproverStatus;
import com.kratonsolution.belian.global.dm.RequestStatus;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequest;
import com.kratonsolution.belian.procurement.dm.PurchaseOrderRequestItem;
import com.kratonsolution.belian.procurement.svc.PurchaseOrderRequestService;
import com.kratonsolution.belian.security.svc.UserService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.NRCToolbar;
import com.kratonsolution.belian.ui.component.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class PurchaseOrderRequestEditContent extends FormContent
{	
	private PurchaseOrderRequestService service = Springs.get(PurchaseOrderRequestService.class);

	private SessionUtils utils = Springs.get(SessionUtils.class);

	private UserService userService = Springs.get(UserService.class);

	private PersonService personService = Springs.get(PersonService.class);

	private Textbox number = Components.readOnlyTextBox();
	
	private Listbox companys = Components.newSelect();

	private Datebox date = Components.currentDatebox();

	private Listbox requester = Components.newSelect();

	private Listbox approver = Components.newSelect();

	private Grid items = new Grid();

	private Row row;

	public PurchaseOrderRequestEditContent(Row row)
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
				PurchaseOrderRequestWindow window = (PurchaseOrderRequestWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});

		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				PurchaseOrderRequest request = service.findOne(RowUtils.string(row, 6));
				if(request != null && request.getRequestStatus().equals(RequestStatus.INCOMPLETE) && request.getApproverStatus().equals(ApproverStatus.SUBMITTED))
				{
					request.getItems().clear();
					service.edit(request);
					
					for(Component com:items.getRows().getChildren())
					{
						Row row = (Row)com;
						
						PurchaseOrderRequestItem item = new PurchaseOrderRequestItem();
						item.setNote(RowUtils.string(row, 3));
						item.setProduct(Components.product(row, 1));
						item.setRequest(request);
						item.setQuantity(RowUtils.decimal(row, 2));
						
						request.getItems().add(item);
					}
					
					service.edit(request);
				}
				
				PurchaseOrderRequestWindow window = (PurchaseOrderRequestWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		PurchaseOrderRequest request = service.findOne(RowUtils.string(row, 6));
		if(request != null)
		{
			if(Strings.isNullOrEmpty(request.getNumber()))
				request.setNumber(PurchaseOrderRequest.NCODE+System.currentTimeMillis());
				
			number.setText(request.getNumber());
			date.setValue(request.getDate());
			companys.appendChild(new Listitem(request.getOrganization().getLabel(),request.getOrganization().getValue()));
			companys.setSelectedIndex(0);
			requester.appendChild(new Listitem(request.getRequester().getLabel(),request.getRequester().getValue()));
			requester.setSelectedIndex(0);
			approver.appendChild(new Listitem(request.getApprover().getLabel(), request.getApprover().getValue()));
			approver.setSelectedIndex(0);
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"125px"));
			grid.getColumns().appendChild(new Column());
			
			Row row1 = new Row();
			row1.appendChild(new Label("Date"));
			row1.appendChild(date);
			
			Row row2 = new Row();
			row2.appendChild(new Label("Company"));
			row2.appendChild(companys);
			
			Row row3 = new Row();
			row3.appendChild(new Label("Requested By"));
			row3.appendChild(requester);
			
			Row row4 = new Row();
			row4.appendChild(new Label("Approver"));
			row4.appendChild(approver);
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row3);
			rows.appendChild(row4);
		}
	}
	
	public void initItems()
	{
		PurchaseOrderRequest request = service.findOne(RowUtils.string(row, 6));
		if(request != null)
		{
			NRCToolbar nrc = new NRCToolbar(items);

			items.setWidth("100%");
			items.appendChild(new Rows());
			items.appendChild(new Columns());
			items.getColumns().appendChild(new Column(null,null,"25px"));
			items.getColumns().appendChild(new Column("Product",null,"150px"));
			items.getColumns().appendChild(new Column("Quantity",null,"100px"));
			items.getColumns().appendChild(new Column("Note",null,"150px"));
			items.setSpan("1");
			
			for(PurchaseOrderRequestItem item:request.getItems())
			{
				ProductBox box = new ProductBox();
				box.setProduct(item.getProduct());
				
				Row row = new Row();
				row.appendChild(Components.checkbox(false));
				row.appendChild(box);
				row.appendChild(Components.doubleBox(item.getQuantity().doubleValue()));
				row.appendChild(Components.textBox(item.getNote()));
				
				items.getRows().appendChild(row);
			}
			
			nrc.getNew().addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					Row row = new Row();
					row.appendChild(Components.checkbox(false));
					row.appendChild(new ProductBox());
					row.appendChild(Components.doubleBox(1));
					row.appendChild(Components.textBox(null));
					
					items.getRows().appendChild(row);
				}
			});
			
			appendChild(nrc);
			appendChild(items);
		}
	}
}
