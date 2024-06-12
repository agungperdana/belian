package com.kratonsolution.belian.inventory.svc;

import com.kratonsolution.belian.common.app.AbstractService;
import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.inventoryitem.impl.orm.InventoryItem;
import com.kratonsolution.belian.inventoryitem.impl.repository.InventoryItemRepository;
import com.kratonsolution.belian.common.orm.Stockable;
import com.kratonsolution.belian.product.impl.orm.Product;
import com.kratonsolution.belian.product.impl.orm.ProductComponent;
import com.kratonsolution.belian.product.impl.orm.ProductType;
import com.kratonsolution.belian.product.impl.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor=Exception.class)
@AllArgsConstructor
public class StockService extends AbstractService
{
	private InventoryItemRepository repository;

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
		Product product = productRepository.findById(prodRef.getId()).orElse(null);

		if(!product.getType().equals(ProductType.SERVICE) && product.getComponents().isEmpty())
		{
			InventoryItem inventoryItem = null;

			if(expired != null)
				inventoryItem = repository.findById(product.getId(), facility.getId(), container.getId(), expired);
			else
				inventoryItem = repository.findById(product.getId(), facility.getId(), container.getId());

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
		Product product = productRepository.findById(prodRef.getId()).orElse(null);

		if(!product.getType().equals(ProductType.SERVICE) && product.getComponents().isEmpty())
		{
			InventoryItem inventoryItem = null;

			if(expired != null)
				inventoryItem = repository.findById(product.getId(), facility.getId(), container.getId(), expired);
			else
				inventoryItem = repository.findById(product.getId(), facility.getId(), container.getId());

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
