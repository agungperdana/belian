/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.FacilityOrganization;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.inventory.dm.Product;

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
	
	public void inventoryProccess(Product product,BigDecimal quantity)
	{
		if(!product.getType().equals(Product.Type.SERVICE))
		{
			BigDecimal unissued = quantity;
			
			for(FacilityOrganization facility:utils.getOrganization().getFacilitys())
			{
				InventoryItem out = itemRepository.findOne(product.getId(), facility.getFacility().getId());
				if(out != null && out.getOnhand().compareTo(BigDecimal.ZERO) > 0)
				{
					if(out.getOnhand().compareTo(unissued) >= 0)
					{
						out.setOnhand(out.getOnhand().subtract(unissued));
						unissued = BigDecimal.ZERO;
					}
					else
					{
						out.setOnhand(BigDecimal.ZERO);
						unissued = unissued.subtract(out.getOnhand());
					}
					
					itemRepository.save(out);
				}
				
				if(unissued.intValue() == 0)
					break;
			}
			
			if(unissued.compareTo(BigDecimal.ZERO) > 0)
				throw new RuntimeException("Product "+product.getName()+" out of stock.");
		}
	}
}
