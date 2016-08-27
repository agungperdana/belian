/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.IndustrySegmentation;
import com.kratonsolution.belian.inventory.dm.InventoryItemRepository;
import com.kratonsolution.belian.inventory.dm.ProductComponent;
import com.kratonsolution.belian.inventory.dm.ProductCost;
import com.kratonsolution.belian.inventory.dm.ProductSupplier;
import com.kratonsolution.belian.inventory.dm.ProductType;
import com.kratonsolution.belian.products.dm.Product;
import com.kratonsolution.belian.products.dm.ProductFeature;
import com.kratonsolution.belian.products.dm.ProductIdentification;
import com.kratonsolution.belian.products.dm.PriceComponent;
import com.kratonsolution.belian.products.dm.ProductRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ProductService
{
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private InventoryItemRepository itemRepo;
	
	@Autowired
	private SessionUtils utils;
	
	@Secured("ROLE_PRODUCT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PRODUCT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public int size(String key)
	{
		if(!Strings.isNullOrEmpty(key))
			return repository.count(key).intValue();
		else
			return size();
	}
	
	@Secured("ROLE_PRODUCT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Product findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_PRODUCT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public void checkStock(Product product,BigDecimal quantity)
	{
		if(product == null)
			throw new RuntimeException("Stock doesnot exist.");
		
		if(product.getType().equals(ProductType.SERVICE) && product.getComponents().isEmpty())
			return;
		
		if(product.getComponents().isEmpty())
		{
			BigDecimal onhand = itemRepo.onHand(product.getId(), utils.getFacilitys());
			if(onhand == null)
				throw new RuntimeException("Stock doesnot exist.");
			else if(onhand.compareTo(quantity) < 0)
				throw new RuntimeException("Stock for product "+product.getCode()+" less than required quantity");
		}
		else
		{
			for(ProductComponent component:product.getComponents())
				checkStock(component.getProduct(), component.getQuantity().multiply(quantity));
		}
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public Product findOneByName(String name)
	{
		return repository.findOneByName(name);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public Product findOneByNameOrId(String nameOrId)
	{
		return repository.findOneByNameOrId(nameOrId,nameOrId);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAll()
	{
		return repository.findAll(new Sort(Direction.ASC,"code","name"));
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAll(Date date,String name)
	{
		if(date == null && Strings.isNullOrEmpty(name))
			return repository.findAll();
			
		if(Strings.isNullOrEmpty(name))
			return repository.findAll(date);
		else
			return repository.findAll(date, name);
		
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAll(Date date,String category,IndustrySegmentation segmentation,ProductType type,String name)
	{
		if(Strings.isNullOrEmpty(name))
			return repository.findAll(date,category,segmentation,type);
		else
			return repository.findAll(date,category,segmentation,type,name);
	
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize,new Sort(Direction.ASC,"code","name"))).getContent();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAll(int pageIndex,int pageSize,String key)
	{
		if(!Strings.isNullOrEmpty(key))
			return repository.findAll(new PageRequest(pageIndex, pageSize),key);
		else
			return findAll(pageIndex, pageSize);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAllActiveByCategory(String categoryId,Date date)
	{
		return repository.findAllActiveProductByCategory(categoryId, date);
	}
		
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAllBySegmentationAndName(IndustrySegmentation segmentation,String name,ProductType type)
	{
		return repository.findAllBySegmentationAndNameAndType(segmentation,name,type);
	}
	
	@Secured("ROLE_PRODUCT_CREATE")
	public void add(Product product)
	{
		repository.save(product);
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void edit(Product product)
	{
		repository.saveAndFlush(product);
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void edit(Product product,
					 Collection<ProductIdentification> codes,
					 Collection<ProductFeature> features,
					 Collection<ProductComponent> components,
					 Collection<PriceComponent> prices,
					 Collection<ProductCost> costs,
					 Collection<ProductSupplier> suppliers)
	{
		product.getCodes().clear();
		product.getFeatures().clear();
		product.getComponents().clear();
		product.getPrices().clear();
		product.getCosts().clear();
		product.getSuppliers().clear();
		
		repository.saveAndFlush(product);
	}
	
	@Secured("ROLE_PRODUCT_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void addCode(Product product,ProductIdentification code)
	{
		code.setId(UUID.randomUUID().toString());
		code.setProduct(product);
		product.getCodes().add(code);
		
		edit(product);
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void editCode(ProductIdentification code)
	{
		edit(code.getProduct());
	}
	
	@Secured("ROLE_PRODUCT_READ")
	public ProductIdentification findCode(Product product,String codeId)
	{
		Product on = repository.findOne(product.getId());
		if(on != null)
		{
			Iterator<ProductIdentification> iterator = on.getCodes().iterator();
			while (iterator.hasNext())
			{
				ProductIdentification productCode = (ProductIdentification) iterator.next();
				if(productCode.getId().equals(codeId))
					return productCode;
			}
		}
		
		return null;
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void addFeature(Product product,ProductFeature feature)
	{
		feature.setId(UUID.randomUUID().toString());
		feature.setProduct(product);
		product.getFeatures().add(feature);
		
		edit(product);
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void editFeature(ProductFeature feature)
	{
		edit(feature.getProduct());
	}
	
	@Secured("ROLE_PRODUCT_READ")
	public ProductFeature findFeature(Product product,String featureId)
	{
		Product on = repository.findOne(product.getId());
		if(on != null)
		{
			Iterator<ProductFeature> iterator = on.getFeatures().iterator();
			while (iterator.hasNext())
			{
				ProductFeature feature = (ProductFeature) iterator.next();
				if(feature.getId().equals(featureId))
					return feature;
			}
		}
		
		return null;
	}
	
	public void removeFeature(Product product,String feature)
	{
		Iterator<ProductFeature> iterator = product.getFeatures().iterator();
		while (iterator.hasNext())
		{
			ProductFeature productFeature = (ProductFeature) iterator.next();
			if(productFeature.getId().equals(feature))
			{
				iterator.remove();
				break;
			}
		}
		
		edit(product);
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void addComponent(Product product,ProductComponent component)
	{
		component.setParent(product);
		product.getComponents().add(component);
		
		edit(product);
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void editComponent(ProductComponent component)
	{
		edit(component.getProduct());
	}
	
	@Secured("ROLE_PRODUCT_READ")
	public ProductComponent findComponent(Product product,String componentId)
	{
		Product on = repository.findOne(product.getId());
		if(on != null)
		{
			Iterator<ProductComponent> iterator = on.getComponents().iterator();
			while (iterator.hasNext())
			{
				ProductComponent component = (ProductComponent) iterator.next();
				if(component.getId().equals(componentId))
					return component;
			}
		}
		
		return null;
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void addSupplier(Product product,ProductSupplier supplier)
	{
		supplier.setId(UUID.randomUUID().toString());
		supplier.setProduct(product);
		product.getSuppliers().add(supplier);
		
		edit(product);
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void editSupplier(ProductSupplier supplier)
	{
		edit(supplier.getProduct());
	}
	
	@Secured("ROLE_PRODUCT_READ")
	public ProductSupplier findSupplier(Product product,String supplierId)
	{
		Product on = repository.findOne(product.getId());
		if(on != null)
		{
			Iterator<ProductSupplier> iterator = on.getSuppliers().iterator();
			while (iterator.hasNext())
			{
				ProductSupplier component = (ProductSupplier) iterator.next();
				if(component.getId().equals(supplierId))
					return component;
			}
		}
		
		return null;
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void addPrice(Product product,PriceComponent price)
	{
		price.setProduct(product);
		product.getPrices().add(price);
		
		edit(product);
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void editPrice(PriceComponent supplier)
	{
		edit(supplier.getProduct());
	}
	
	@Secured("ROLE_PRODUCT_READ")
	public PriceComponent findPrice(Product product,String priceId)
	{
		Product on = repository.findOne(product.getId());
		if(on != null)
		{
			Iterator<PriceComponent> iterator = on.getPrices().iterator();
			while (iterator.hasNext())
			{
				PriceComponent price = (PriceComponent) iterator.next();
				if(price.getId().equals(priceId))
					return price;
			}
		}
		
		return null;
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void addCost(Product product,ProductCost cost)
	{
		cost.setId(UUID.randomUUID().toString());
		cost.setProduct(product);
		product.getCosts().add(cost);
		
		edit(product);
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void editCost(ProductCost cost)
	{
		edit(cost.getProduct());
	}
	
	@Secured("ROLE_PRODUCT_READ")
	public ProductCost findCost(Product product,String costId)
	{
		Product on = repository.findOne(product.getId());
		if(on != null)
		{
			Iterator<ProductCost> iterator = on.getCosts().iterator();
			while (iterator.hasNext())
			{
				ProductCost cost = (ProductCost) iterator.next();
				if(cost.getId().equals(costId))
					return cost;
			}
		}
		
		return null;
	}
}
