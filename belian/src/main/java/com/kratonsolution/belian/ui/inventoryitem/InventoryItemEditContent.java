/**
 * 
 */
package com.kratonsolution.belian.ui.inventoryitem;

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
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * @author agungdodiperdana
 *
 */
public class InventoryItemEditContent extends FormContent
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

	private Row row;

	public InventoryItemEditContent(Row row)
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
				InventoryItemWindow window = (InventoryItemWindow)getParent();
				window.removeEditForm();
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
			
				InventoryItem item = service.findOne(RowUtils.rowValue(row, 6));
				item.setProduct(productService.findOne(products.getSelectedItem().getValue().toString()));
				item.setFacility(facilityService.findOne(facilitys.getSelectedItem().getValue().toString()));
				item.setOnhand(BigDecimal.valueOf(onhand.getValue()));
				item.setSerialNumber(serial.getText());
				
				if(containers.getSelectedCount() > 0)
					item.setContainer(containerService.findOne(containers.getSelectedItem().getValue().toString()));
				
				service.edit(item);

				InventoryItemWindow window = (InventoryItemWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		final InventoryItem item = service.findOne(RowUtils.rowValue(row,6));
		
		products.setMold("select");
		facilitys.setMold("select");
		containers.setMold("select");
		
		onhand.setConstraint("no empty");
		onhand.setWidth("200px");
		onhand.setValue(item.getOnhand().doubleValue());
		
		serial.setWidth("300px");
		serial.setText(item.getSerialNumber());
		
		for(Product product:productService.findAll())
		{
			Listitem listitem = new Listitem(product.getName(),product.getId());
			products.appendChild(listitem);
			if(product.getId().equals(item.getProduct().getId()))
				products.setSelectedItem(listitem);
		}
		
		for(final Facility facility:facilityService.findAll())
		{
			Listitem listitem = new Listitem(facility.getName(),facility.getId());
			listitem.addEventListener(Events.ON_CLICK,new EventListener<Event>()
			{
				@Override
				public void onEvent(Event event) throws Exception
				{
					containers.getChildren().clear();
					for(Container container:facility.getContainers())
					{
						Listitem list = new Listitem(container.getName(),container.getId());
						containers.appendChild(list);
						
						if(item.getContainer() != null && item.getContainer().getId().equals(container.getId()))
							containers.setSelectedItem(list);
					}
				}
			});
			
			facilitys.appendChild(listitem);
		}
		
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
