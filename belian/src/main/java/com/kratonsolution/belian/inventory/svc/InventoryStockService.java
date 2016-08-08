/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.Facility;
import com.kratonsolution.belian.inventory.dm.FacilityOrganization;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductComponent;
import com.kratonsolution.belian.inventory.dm.ProductType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class InventoryStockService
{
	@Autowired
	private SessionUtils utils;

	@Autowired
	private InventoryItemRepository itemRepository;

	public void issue(Product product,BigDecimal quantity)
	{
		if(!product.getType().equals(ProductType.SERVICE))
		{
			BigDecimal unissued = quantity;

			for(FacilityOrganization facility:utils.getOrganization().getFacilitys())
			{
				List<InventoryItem> outs = itemRepository.findAll(product.getId(), facility.getFacility().getId());
				for(InventoryItem out: outs)
				{
					if(out.getOnhand().compareTo(BigDecimal.ZERO) > 0)
					{
						if(out.getOnhand().compareTo(unissued) >= 0)
						{
							out.setOnhand(out.getOnhand().subtract(unissued));
							unissued = BigDecimal.ZERO;
						}
						else
						{
							unissued = unissued.subtract(out.getOnhand());
							out.setOnhand(BigDecimal.ZERO);
						}

						itemRepository.save(out);
					}

					if(unissued.intValue() == 0)
						break;
				}

				if(unissued.intValue() == 0)
					break;
			}

			if(unissued.compareTo(BigDecimal.ZERO) > 0)
				throw new RuntimeException("Product "+product.getName()+" out of stock.");
		}
	}

	public void issue(Facility facility,Product product,BigDecimal quantity,Date expired)
	{
		if(quantity == null)
			throw new RuntimeException("Quantity cannot be empty.");

		if(product.getComponents().isEmpty())
			substract(facility, product, quantity, expired);
		else
		{
			for(ProductComponent com:product.getComponents())
				substract(facility, com.getProduct(), com.getQuantity().multiply(quantity), expired);
		}
	}

	private void substract(Facility facility, Product product,BigDecimal quantity, Date expired)
	{
		if(facility == null)
			throw new RuntimeException("Facility cannot be empty");
		
		if(product == null)
			throw new RuntimeException("Product cannot be empty");
		
		InventoryItem item = null;

		if(expired != null)
			item = itemRepository.findOne(product.getId(), facility.getId(), expired);
		else
			item = itemRepository.findOne(product.getId(), facility.getId());

		if(item == null)
			throw new RuntimeException("Required product does not exist on selected facility.");
		
		if(item.getOnhand().compareTo(quantity) < 0)
			throw new RuntimeException("Onhand quantity less than required quantity.");
		
		item.setOnhand(item.getOnhand().subtract(quantity));
		itemRepository.save(item);
	}

	public void receive(Facility facility,Product product,BigDecimal quantity,Date expired)
	{
		if(quantity == null)
			throw new RuntimeException("Quantity cannot be empty.");

		InventoryItem item = null;

		if(expired != null)
			item = itemRepository.findOne(product.getId(), facility.getId(), expired);
		else
			item = itemRepository.findOne(product.getId(), facility.getId());

		if(item != null)
		{
			item.setOnhand(item.getOnhand().add(quantity));
			itemRepository.save(item);
		}
		else
		{
			InventoryItem inventoryItem = new InventoryItem();
			inventoryItem.setExpiredDate(expired);
			inventoryItem.setFacility(facility);
			inventoryItem.setOnhand(quantity);
			inventoryItem.setProduct(product);

			itemRepository.save(inventoryItem);
		}
	}
}
