/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Menupopup;
import org.zkoss.zul.Menuseparator;

import com.kratonsolution.belian.ui.inventory.facility.FacilityMenu;
import com.kratonsolution.belian.ui.inventorys.inventoryitem.InventoryItemMenu;
import com.kratonsolution.belian.ui.inventorys.shipment.ShipmentMenu;
import com.kratonsolution.belian.ui.inventorys.shipmentissuance.ShipmentIssuanceMenu;
import com.kratonsolution.belian.ui.inventorys.shipmentreceipt.ShipmentReceiptMenu;
import com.kratonsolution.belian.ui.inventorys.stockadjustment.StockAdjustmentMenu;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Inventory extends AbstractMenu
{
	private FacilityMenu facility = new FacilityMenu();
	
	private InventoryItemMenu stock = new InventoryItemMenu();
	
	private StockAdjustmentMenu adjustment = new StockAdjustmentMenu();
	
	private ShipmentMenu shipmentMenu = new ShipmentMenu();

	private ShipmentReceiptMenu shipmentReceiptMenu = new ShipmentReceiptMenu();
	
	private ShipmentIssuanceMenu issuanceMenu = new ShipmentIssuanceMenu();
	
	public Inventory()
	{
		setLabel(lang.get("navbar.menu.inventory"));
		setImage("/icons/inventory16.png");
		
		Menupopup popup = new Menupopup();

		if(!facility.isDisabled())
		{
			popup.appendChild(facility);
			popup.appendChild(new Menuseparator());
		}

		if(!stock.isDisabled())
		{
			popup.appendChild(stock);
			popup.appendChild(new Menuseparator());
		}
		
		if(!adjustment.isDisabled())
		{
			popup.appendChild(adjustment);
			popup.appendChild(new Menuseparator());
		}

		if(!shipmentMenu.isDisabled())
		{
			popup.appendChild(shipmentMenu);
			popup.appendChild(new Menuseparator());
		}
		
		if(!shipmentReceiptMenu.isDisabled())
		{
			popup.appendChild(shipmentReceiptMenu);
			popup.appendChild(new Menuseparator());
		}
		
		if(!issuanceMenu.isDisabled())
		{
			popup.appendChild(issuanceMenu);
		}
		
		if(!popup.getChildren().isEmpty())
			appendChild(popup);
	}
}
