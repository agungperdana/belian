
package com.kratonsolution.belian.ui.inventorys.inventoryitem;

import java.math.BigDecimal;

import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

import com.kratonsolution.belian.common.util.DateTimes;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.svc.InventoryItemService;
import com.kratonsolution.belian.ui.AbstractForm;
import com.kratonsolution.belian.ui.general.companystructure.CompanyStructureList;
import com.kratonsolution.belian.ui.inventory.facility.ContainerList;
import com.kratonsolution.belian.ui.inventory.facility.FacilityList;
import com.kratonsolution.belian.ui.products.product.ProductBox;
import com.kratonsolution.belian.ui.util.Components;
import com.kratonsolution.belian.ui.util.Flow;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class InventoryItemFormContent extends AbstractForm
{	
	private InventoryItemService service = Springs.get(InventoryItemService.class);
	
	private CompanyStructureList organizations = new CompanyStructureList(false);
	
	private ProductBox products = new ProductBox(false);
	
	private FacilityList facilitys = new FacilityList(false);
	
	private ContainerList containers = new ContainerList(false);
	
	private Textbox serials = Components.stdTextBox(null,false);
	
	private Datebox expired = Components.datebox();
	
	private Decimalbox onhand = Components.decimalbox(BigDecimal.ONE);
	
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
				if(organizations.getDomain() == null)
					throw new WrongValueException(organizations,lang.get("message.field.empty"));
				
				if(products.getDomain() == null)
					throw new WrongValueException(products,lang.get("message.field.empty"));
				
				if(facilitys.getDomain() == null)
					throw new WrongValueException(facilitys,lang.get("message.field.empty"));
				
				if(containers.getDomain() == null)
					throw new WrongValueException(containers,lang.get("message.field.empty"));

				if(onhand.getValue().equals(BigDecimal.ZERO))
					throw new WrongValueException(onhand,lang.get("message.field.empty"));
					
				InventoryItem inv = new InventoryItem();
				inv.setOrganization(organizations.getDomainAsRef());
				inv.setContainer(containers.getDomainAsRef());
				inv.setExpiredDate(DateTimes.sql(expired.getValue()));
				inv.setFacility(facilitys.getDomainAsRef());
				inv.setOnhand(onhand.getValue());
				inv.setProduct(products.getDomainAsRef());
				inv.setSerialNumber(serials.getText());
				inv.getLog().setCreated(DateTimes.timestamp());
				inv.getLog().setCreator(utils.getUser().getUserName());
				
				service.add(inv);
				
				Flow.next(getParent(), new InventoryItemGridContent());
			}
		});
	}

	@Override
	public void initForm()
	{
		facilitys.addObserver(containers);
		
		grid.appendChild(new Columns());
		grid.getColumns().appendChild(new Column(null,null,"100px"));
		grid.getColumns().appendChild(new Column());
		
		Row row0 = new Row();
		row0.appendChild(new Label(lang.get("inventoryitem.grid.column.organization")));
		row0.appendChild(organizations);
		
		Row row1 = new Row();
		row1.appendChild(new Label(lang.get("inventoryitem.grid.column.product")));
		row1.appendChild(products);
		
		Row row2 = new Row();
		row2.appendChild(new Label(lang.get("inventoryitem.grid.column.facility")));
		row2.appendChild(facilitys);
		
		Row row3 = new Row();
		row3.appendChild(new Label(lang.get("inventoryitem.grid.column.container")));
		row3.appendChild(containers);
		
		Row row4 = new Row();
		row4.appendChild(new Label(lang.get("inventoryitem.grid.column.onhand")));
		row4.appendChild(onhand);
		
		Row row5 = new Row();
		row5.appendChild(new Label(lang.get("inventoryitem.grid.column.expired")));
		row5.appendChild(expired);
		
		Row row6 = new Row();
		row6.appendChild(new Label(lang.get("inventoryitem.grid.column.serial")));
		row6.appendChild(serials);
		
		rows.appendChild(row0);
		rows.appendChild(row1);
		rows.appendChild(row2);
		rows.appendChild(row3);
		rows.appendChild(row4);
		rows.appendChild(row5);
		rows.appendChild(row6);
	}
}
