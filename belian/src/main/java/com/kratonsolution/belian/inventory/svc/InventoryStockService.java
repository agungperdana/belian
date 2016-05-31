/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.inventory.dm.FacilityOrganization;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.inventory.dm.Product;
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
	
	public void inventoryProccess(Product product,BigDecimal quantity)
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
}
