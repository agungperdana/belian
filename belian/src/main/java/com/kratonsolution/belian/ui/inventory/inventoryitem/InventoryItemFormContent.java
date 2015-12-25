/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.inventoryitem;

import java.math.BigDecimal;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.inventory.dm.Container;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.svc.ContainerService;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.inventory.svc.InventoryItemService;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.FormContent;
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
	
	private ContainerService containerService = Springs.get(ContainerService.class);
	
	private Listbox products = new Listbox();
	
	private Listbox facilitys = new Listbox();
	
	private Listbox containers = new Listbox();
	
	private Textbox serial = new Textbox();
	
	private Doublebox onhand = new Doublebox(1d);
	
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
				InventoryItemWindow window = (InventoryItemWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(Strings.isNullOrEmpty(onhand.getText()))
					throw new WrongValueException(onhand,"On Hand cannot be empty");
			
				InventoryItem item = new InventoryItem();
				item.setProduct(productService.findOne(products.getSelectedItem().getValue().toString()));
				item.setFacility(facilityService.findOne(facilitys.getSelectedItem().getValue().toString()));
				item.setOnhand(BigDecimal.valueOf(onhand.getValue()));
				item.setSerialNumber(serial.getText());
				
				if(containers.getSelectedCount() > 0)
					item.setContainer(containerService.findOne(containers.getSelectedItem().getValue().toString()));
				
				service.add(item);
				
				InventoryItemWindow window = (InventoryItemWindow)getParent();
				window.removeCreateForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		products.setMold("select");
		facilitys.setMold("select");
		containers.setMold("select");
		
		onhand.setConstraint("no empty");
		onhand.setWidth("200px");
		
		serial.setWidth("300px");
		
		for(Product product:productService.findAll())
			products.appendChild(new Listitem(product.getName(),product.getId()));
		
		if(!products.getChildren().isEmpty())
			products.setSelectedIndex(0);
		
		for(final Facility facility:facilityService.findAll())
			facilitys.appendChild(new Listitem(facility.getName(),facility.getId()));
		
		facilitys.addEventListener(Events.ON_SELECT, new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				containers.getChildren().clear();
				
				for(Container container:containerService.findAllByFacility(facilitys.getSelectedItem().getValue().toString()))
					containers.appendChild(new Listitem(container.getName(),container.getId()));
			}
		});
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"75px"));
		grid.getColumns().appendChild(new Column());
		
		Row row1 = new Row();
		row1.appendChild(new Label("Product"));
		row1.appendChild(products);
		
		Row row2 = new Row();
		row2.appendChild(new Label("Facility"));
		row2.appendChild(facilitys);
		
		Row row3 = new Row();
		row3.appendChild(new Label("Container"));
		row3.appendChild(containers);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Serial"));
		row4.appendChild(serial);
		
		Row row5 = new Row();
		row5.appendChild(new Label("On Hand"));
		row5.appendChild(onhand);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
	}
}
