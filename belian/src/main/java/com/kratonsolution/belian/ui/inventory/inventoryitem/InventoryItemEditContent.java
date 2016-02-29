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
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.google.common.base.Strings;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.inventory.svc.InventoryItemService;
import com.kratonsolution.belian.inventory.svc.ProductService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InventoryItemEditContent extends FormContent
{	
	private InventoryItemService service = Springs.get(InventoryItemService.class);

	private ProductService productService = Springs.get(ProductService.class);

	private FacilityService facilityService = Springs.get(FacilityService.class);

	private ProductBox products = new ProductBox();

	private Listbox facilitys = Components.newSelect();

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
			
				InventoryItem item = service.findOne(RowUtils.string(row, 5));
				if(item != null)
				{
					item.setOnhand(BigDecimal.valueOf(onhand.getValue()));
					service.edit(item);
				}

				InventoryItemWindow window = (InventoryItemWindow)getParent();
				window.removeEditForm();
				window.insertGrid();
			}
		});
	}

	@Override
	public void initForm()
	{
		InventoryItem item = service.findOne(RowUtils.string(row,5));
		if(item != null)
		{
			products.setProduct(item.getProduct());
			products.setDisabled(true);
			
			onhand.setConstraint("no empty");
			onhand.setWidth("200px");
			onhand.setValue(item.getOnhand().doubleValue());
			
			serial.setWidth("300px");
			serial.setText(item.getSerialNumber());
			serial.setReadonly(true);
			
			facilitys.appendItem(item.getFacility().getLabel(), item.getFacility().getId());
			facilitys.setSelectedIndex(0);
			
			grid.appendChild(new Columns());
			grid.getColumns().appendChild(new Column(null,null,"100px"));
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
			
			rows.appendChild(row1);
			rows.appendChild(row2);
			rows.appendChild(row4);
			rows.appendChild(row5);
		}
	}
}
