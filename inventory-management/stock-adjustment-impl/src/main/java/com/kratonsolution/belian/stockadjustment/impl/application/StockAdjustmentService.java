package com.kratonsolution.belian.stockadjustment.impl.application;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.app.DateTimes;
import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.common.app.SessionUtil;
import com.kratonsolution.belian.inventoryitem.impl.orm.InventoryItem;
import com.kratonsolution.belian.inventoryitem.impl.repository.InventoryItemRepository;
import com.kratonsolution.belian.stockadjustment.impl.orm.StockAdjustment;
import com.kratonsolution.belian.stockadjustment.impl.orm.StockAdjustmentItem;
import com.kratonsolution.belian.stockadjustment.impl.orm.StockAdjustmentType;
import com.kratonsolution.belian.stockadjustment.impl.repository.StockAdjustmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor=Exception.class)
@AllArgsConstructor
public class StockAdjustmentService
{
	private StockAdjustmentRepository repository;

	private InventoryItemRepository itemRepository;

	private Language lang;

	private SessionUtil utils;

	@Secured("ROLE_STOCK_ADJUSTMENT_READ")
	public int size()
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;

		return repository.count(utils.getOrganizationIds()).intValue();
	}

	@Secured("ROLE_STOCK_ADJUSTMENT_READ")
	public int size(String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return 0;

		if(Strings.isNullOrEmpty(key))
			return size();

		return repository.count(utils.getOrganizationIds(),key).intValue();
	}

	@Secured("ROLE_STOCK_ADJUSTMENT_READ")
	public StockAdjustment findById(String id)
	{
		return repository.findById(id).orElse(null);
	}

	@Secured("ROLE_STOCK_ADJUSTMENT_READ")
	public List<StockAdjustment> findAll()
	{
		return repository.findAll();
	}


	@Secured("ROLE_STOCK_ADJUSTMENT_READ")
	public List<StockAdjustment> findAll(int pageIndex,int pageSize)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();

		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganizationIds());
	}

	@Secured("ROLE_STOCK_ADJUSTMENT_READ")
	public List<StockAdjustment> findAll(int pageIndex,int pageSize,String key)
	{
		if(utils.getOrganizationIds().isEmpty())
			return new ArrayList<>();

		if(Strings.isNullOrEmpty(key))
			return findAll(pageIndex, pageSize);

		return repository.findAll(PageRequest.of(pageIndex, pageSize),utils.getOrganizationIds(),key);
	}

	@Secured("ROLE_STOCK_ADJUSTMENT_CREATE")
	public void add(StockAdjustment stock)
	{
		repository.save(stock);

		for(StockAdjustmentItem item:stock.getItems())
		{
			InventoryItem inv = null;
			if(item.getExpired() != null)
				inv = itemRepository.findById(item.getProduct().getId(), stock.getFacility().getId(), item.getContainer().getId(),item.getExpired());
			else
				inv = itemRepository.findById(item.getProduct().getId(), stock.getFacility().getId(), item.getContainer().getId());

			if(inv == null)
			{
				inv = new InventoryItem();
				inv.setContainer(item.getContainer());
				inv.setExpiredDate(item.getExpired());
				inv.setFacility(stock.getFacility());
				inv.setOnhand(item.getAdjustment());
				inv.setProduct(item.getProduct());
				inv.setOrganization(stock.getOrganization());
				inv.getLog().setCreated(DateTimes.timestamp());
				inv.getLog().setCreator(utils.getUser().getUserName());
			}
			else
			{
				inv.getLog().setEditor(utils.getUser().getUserName());
				inv.getLog().setLastEdited(DateTimes.timestamp());

				if(item.getType().equals(StockAdjustmentType.ADDITION))
					inv.setOnhand(inv.getOnhand().add(item.getAdjustment()));
				else if(item.getType().equals(StockAdjustmentType.REPLACE))
					inv.setOnhand(item.getAdjustment());
				else
				{
					if(inv.getOnhand().compareTo(item.getAdjustment()) < 0)
						throw new RuntimeException(lang.get("inventory.message.stockless"));

					inv.setOnhand(inv.getOnhand().subtract(item.getAdjustment()));
				}
			}

			itemRepository.save(inv);
		}
	}

	@Secured("ROLE_STOCK_ADJUSTMENT_UPDATE")
	public void edit(StockAdjustment StockAdjustment)
	{
		repository.saveAndFlush(StockAdjustment);
	}

	@Secured("ROLE_STOCK_ADJUSTMENT_DELETE")
	public void delete(String id)
	{
		StockAdjustment stock = repository.findById(id).orElse(null);
		if(stock != null)
		{
			for(StockAdjustmentItem item:stock.getItems())
			{
				InventoryItem inv = null;
				if(item.getExpired() != null)
					inv = itemRepository.findById(item.getProduct().getId(), stock.getFacility().getId(),item.getContainer().getId(),item.getExpired());
				else
					inv = itemRepository.findById(item.getProduct().getId(), stock.getFacility().getId(),item.getContainer().getId());

				if(inv == null)
					throw new RuntimeException(lang.get("message.field.empty"));

				if(item.getType().equals(StockAdjustmentType.ADDITION))
				{
					if(inv.getOnhand().compareTo(item.getAdjustment()) < 0)
						throw new RuntimeException(lang.get("inventory.message.stockless"));
					
					inv.setOnhand(inv.getOnhand().subtract(item.getAdjustment()));
				}
				else if(item.getType().equals(StockAdjustmentType.SUBSTRACTION))
					inv.setOnhand(inv.getOnhand().add(item.getAdjustment()));
				else
					throw new RuntimeException(lang.get("inventory.message.stockreplaced"));
					
				
				itemRepository.save(inv);
			}
			
			repository.delete(stock);
		}
	}
}
