/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.inventoryitem;

import java.math.BigDecimal;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.inventory.svc.InventoryItemService;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InventoryItemFormContent extends FormContent
{	
	private InventoryItemService service = Springs.get(InventoryItemService.class);
	
	private ProductService productService = Springs.get(ProductService.class);
	
	private FacilityService facilityService = Springs.get(FacilityService.class);
	
	private ProductBox products = new ProductBox();
	
	private Listbox facilitys = Components.newSelect(facilityService.findAll(), true);
	
	private Textbox serial = new Textbox();
	
	private Doublebox onhand = new Doublebox(1d);
	
	private Datebox expired = Components.mandatoryDatebox("150px");
	
	public InventoryItemFormContent()
	{
		super();
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
				Flow.next(getParent(), new InventoryItemGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(onhand.getText()))
					throw new WrongValueException(onhand,"On Hand cannot be empty");
			
				if(products.getProduct() == null)
					throw new WrongValueException(products,"Product cannot be empty");
				
				InventoryItem out = service.findOne(products.getProduct().getId(),Components.string(facilitys),DateTimes.sql(expired.getValue()));
				if(out != null)
				{
					Clients.showNotification("Inventory Item already exist,please use Stock Adjustment instead.");
					return;
				}
				
				InventoryItem item = new InventoryItem();
				item.setProduct(products.getProduct());
				item.setFacility(facilityService.findOne(facilitys.getSelectedItem().getValue().toString()));
				item.setOnhand(BigDecimal.valueOf(onhand.getValue()));
				item.setSerialNumber(serial.getText());
				item.setExpiredDate(DateTimes.sql(expired.getValue()));
				
				service.add(item);
				
				Flow.next(getParent(), new InventoryItemGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		onhand.setConstraint("no empty");
		onhand.setWidth("200px");
		
		serial.setWidth("300px");

		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"125px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Product"));
		row1.appendChild(products);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Facility"));
		row2.appendChild(facilitys);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Serial"));
		row4.appendChild(serial);
		
		Row row5 = new Row();
		row5.appendChild(new Label("On Hand"));
		row5.appendChild(onhand);
		
		Row row6 = new Row();
		row6.appendChild(new Label("Expired Date"));
		row6.appendChild(expired);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}
}
