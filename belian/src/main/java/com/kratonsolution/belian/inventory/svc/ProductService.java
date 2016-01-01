/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.inventory.dm.IndustrySegmentation;
import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.Product.Type;
import com.kratonsolution.belian.inventory.dm.ProductCode;
import com.kratonsolution.belian.inventory.dm.ProductComponent;
import com.kratonsolution.belian.inventory.dm.ProductCost;
import com.kratonsolution.belian.inventory.dm.ProductFeature;
import com.kratonsolution.belian.inventory.dm.ProductPrice;
import com.kratonsolution.belian.inventory.dm.ProductRepository;
import com.kratonsolution.belian.inventory.dm.ProductSupplier;

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
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public Product findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAll()
	{
		return repository.findAll();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAllActiveByCategory(String categoryId,Date date)
	{
		return repository.findAllActiveProductByCategory(categoryId, date);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAllBySegmentation(IndustrySegmentation segmentation,Type type)
	{
		return repository.findAllBySegmentationAndType(segmentation,type);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAllBySegmentationAndName(IndustrySegmentation segmentation,String name,Type type)
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
	
	@Secured("ROLE_PRODUCT_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void addCode(Product product,ProductCode code)
	{
		code.setId(UUID.randomUUID().toString());
		code.setProduct(product);
		product.getCodes().add(code);
		
		edit(product);
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void editCode(ProductCode code)
	{
		edit(code.getProduct());
	}
	
	@Secured("ROLE_PRODUCT_READ")
	public ProductCode findCode(Product product,String codeId)
	{
		Product on = repository.findOne(product.getId());
		if(on != null)
		{
			Iterator<ProductCode> iterator = on.getCodes().iterator();
			while (iterator.hasNext())
			{
				ProductCode productCode = (ProductCode) iterator.next();
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
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void addComponent(Product product,ProductComponent component)
	{
		component.setId(UUID.randomUUID().toString());
		component.setProduct(product);
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
	public void addPrice(Product product,ProductPrice price)
	{
		price.setId(UUID.randomUUID().toString());
		price.setProduct(product);
		product.getPrices().add(price);
		
		edit(product);
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void editPrice(ProductPrice supplier)
	{
		edit(supplier.getProduct());
	}
	
	@Secured("ROLE_PRODUCT_READ")
	public ProductPrice findPrice(Product product,String priceId)
	{
		Product on = repository.findOne(product.getId());
		if(on != null)
		{
			Iterator<ProductPrice> iterator = on.getPrices().iterator();
			while (iterator.hasNext())
			{
				ProductPrice price = (ProductPrice) iterator.next();
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
