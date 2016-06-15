/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.productretur;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.inventory.dm.ProductRetur;
import com.kratonsolution.belian.inventory.dm.ProductReturItem;
import com.kratonsolution.belian.inventory.svc.FacilityService;
import com.kratonsolution.belian.inventory.svc.ProductReturService;
import com.kratonsolution.belian.ui.FormContent;
import com.kratonsolution.belian.ui.component.OrganizationList;
import com.kratonsolution.belian.ui.component.SupplierBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.RowUtils;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ProductReturFormContent extends FormContent
{	
	private ProductReturService service = Springs.get(ProductReturService.class);
	
	private SessionUtils utils = Springs.get(SessionUtils.class);
	
	private FacilityService facilityService = Springs.get(FacilityService.class);
	
	private InventoryItemRepository itemRepository = Springs.get(InventoryItemRepository.class);
	
	private Datebox date = Components.currentDatebox();
	
	private OrganizationList companys = new OrganizationList();
	
	private Listbox facilitys = Components.newSelect(facilityService.findAllActive(),true);
	
	private SupplierBox suppliers = new SupplierBox(true);
	
	private Grid items = new Grid();
	
	public ProductReturFormContent()
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
				Flow.next(getParent(), new ProductReturGridContent());
			}
		});
		
		toolbar.getSave().addEventListener(Events.ON_CLICK,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event event) throws Exception
			{
				if(suppliers.getSupplier() == null)
					throw new WrongValueException(suppliers,"Supplier cannot be empty.");
				
				ProductRetur retur = new ProductRetur();
				retur.setDate(DateTimes.sql(date.getValue()));
				retur.setFacility(facilityService.findOne(Components.string(facilitys)));
				retur.setOrganization(utils.getOrganization());
				retur.setSupplier(suppliers.getSupplier());
				
				for(Component com:items.getRows().getChildren())
				{
					Row row = (Row)com;
					
					InventoryItem inv = itemRepository.findOne(RowUtils.id(row));
					if(inv != null && RowUtils.decimal(row, 2).compareTo(BigDecimal.ZERO) > 0)
					{
						ProductReturItem item = new ProductReturItem();
						item.setExpiredDate(inv.getExpiredDate());
						item.setProduct(inv.getProduct());
						item.setQuantity(RowUtils.decimal(row, 2));
						item.setRetur(retur);
						
						retur.getItems().add(item);
					}
				}
				
				if(!retur.getItems().isEmpty())
					service.add(retur);
				
				Flow.next(getParent(), new ProductReturGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		facilitys.addEventListener(Events.ON_SELECT,new EventListener<Event>()
		{
			@Override
			public void onEvent(Event arg0) throws Exception
			{
				initData();
			}
		});
		
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
		row3.appendChild(new Label("Supplier"));
		row3.appendChild(suppliers);
		
		Row row4 = new Row();
		row4.appendChild(new Label("Facility"));
		row4.appendChild(facilitys);
		
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
	}
	
	private void initItems()
	{
		items.setWidth("100%");
		items.appendChild(new Rows());
		items.appendChild(new Columns());
		items.getColumns().appendChild(new Column("Product",null, "150px"));
		items.getColumns().appendChild(new Column("On Hand",null, "85px"));
		items.getColumns().appendChild(new Column("Retur",null, "85px"));
		items.getColumns().appendChild(new Column("UoM",null, "100px"));
		items.getColumns().appendChild(new Column("Expired",null, "100px"));
		items.getColumns().appendChild(new Column());
		items.getColumns().getLastChild().setVisible(false);
		items.setSpan("0");
		
		appendChild(items);
	
		initData();
	}
	
	private void initData()
	{
		items.getRows().getChildren().clear();
		if(facilitys.getSelectedItem() != null)
		{
			List<String> fac = new ArrayList<>();
			fac.add(Components.string(facilitys));
			for(InventoryItem item:itemRepository.findAllExpired(fac,DateTimes.nextMonth(DateTimes.sql(date.getValue()))))
			{
				Row row = new Row();
				row.appendChild(Components.readOnlyTextBox(item.getProduct().getName()));
				row.appendChild(Components.readOnlyDoubleBox(item.getOnhand().doubleValue()));
				row.appendChild(Components.doubleBox(0d));
				row.appendChild(Components.readOnlyTextBox(item.getProduct().getUom().getCode()));
				row.appendChild(Components.readOnlyTextBox(DateTimes.format(item.getExpiredDate())));
				row.appendChild(Components.label(item.getId()));
				
				items.getRows().appendChild(row);
			}
		}
	}
}
