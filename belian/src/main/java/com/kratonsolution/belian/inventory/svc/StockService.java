/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.global.dm.AbstractService;
import com.kratonsolution.belian.inventory.dm.InventoryItem;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.inventory.dm.Stockable;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductComponent;
import com.kratonsolution.belian.products.dm.ProductRepository;
import com.kratonsolution.belian.products.dm.ProductType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class StockService extends AbstractService
{
	@Autowired
	private InventoryItemRepository repository;

	@Autowired
	private ProductRepository productRepository;

	public void addStock(Collection<? extends Stockable> items)
	{
		for(Stockable stock:items)
		{
			if(stock.isProductValid() && stock.isFacilityValid() && stock.isContainerValid())
				store(stock.getProduct(), stock.getFacility(), stock.getContainer(), stock.getAccepted(), stock.getExpired());
		}
	}
	
	public void removeStock(Collection<? extends Stockable> items)
	{
		for(Stockable stock:items)
		{
			if(stock.isProductValid() && stock.isFacilityValid() && stock.isContainerValid())
				unstore(stock.getProduct(), stock.getFacility(), stock.getContainer(), stock.getAccepted(), stock.getExpired());
		}
	}

	private void store(IDValueRef prodRef,IDValueRef facility,IDValueRef container,BigDecimal quantity,Date expired)
	{
		Product product = productRepository.findOne(prodRef.getId());

		if(!product.getType().equals(ProductType.SERVICE) && product.getComponents().isEmpty())
		{
			InventoryItem inventoryItem = null;

			if(expired != null)
				inventoryItem = repository.findOne(product.getId(), facility.getId(), container.getId(), expired);
			else
				inventoryItem = repository.findOne(product.getId(), facility.getId(), container.getId());

			if(inventoryItem == null)
			{
				inventoryItem = new InventoryItem();
				inventoryItem.setContainer(container);
				inventoryItem.setExpiredDate(expired);
				inventoryItem.setFacility(facility);
				inventoryItem.setOnhand(quantity);
				inventoryItem.setOrganization(IDValueRef.toRef(utils.getOrganization()));
				inventoryItem.setProduct(prodRef);
			}
			else
				inventoryItem.setOnhand(inventoryItem.getOnhand().add(quantity));

			repository.save(inventoryItem);
		}
		else
		{
			for(ProductComponent component:product.getComponents())
				store(component.getProduct(), facility, container, quantity.multiply(component.getQuantity()), expired);
		}
	}

	public void unstore(IDValueRef prodRef,IDValueRef facility,IDValueRef container,BigDecimal quantity,Date expired)
	{
		Product product = productRepository.findOne(prodRef.getId());

		if(!product.getType().equals(ProductType.SERVICE) && product.getComponents().isEmpty())
		{
			InventoryItem inventoryItem = null;

			if(expired != null)
				inventoryItem = repository.findOne(product.getId(), facility.getId(), container.getId(), expired);
			else
				inventoryItem = repository.findOne(product.getId(), facility.getId(), container.getId());

			if(inventoryItem == null || inventoryItem.getOnhand().compareTo(quantity) < 0)
				throw new RuntimeException("Product doesnot exist or stock less than required quantity");
			
			inventoryItem.setOnhand(inventoryItem.getOnhand().subtract(quantity));

			repository.saveAndFlush(inventoryItem);
		}
		else
		{
			for(ProductComponent component:product.getComponents())
				unstore(component.getProduct(), facility, container, quantity.multiply(component.getQuantity()), expired);
		}
	}
}
