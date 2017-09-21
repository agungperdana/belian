/**
 * 
 */
package com.kratonsolution.belian.products.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.products.dm.ProductCategory;
import com.kratonsolution.belian.products.dm.ProductCategoryRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ProductCategoryService
{
	@Autowired
	private ProductCategoryRepository repository;
	
	@Secured("ROLE_PRODUCT_CATEGORY_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PRODUCT_CATEGORY_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public ProductCategory findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_CATEGORY_READ")
	public List<ProductCategory> findAll()
	{
		return repository.findAll();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_CATEGORY_READ")
	public List<ProductCategory> findAllParent()
	{
		return repository.findAllParent();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_CATEGORY_READ")
	public List<ProductCategory> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_PRODUCT_CATEGORY_CREATE")
	public void add(ProductCategory category)
	{
		repository.save(category);
	}
	
	@Secured("ROLE_PRODUCT_CATEGORY_UPDATE")
	public void edit(ProductCategory category)
	{
		repository.saveAndFlush(category);
	}
	
	@Secured("ROLE_PRODUCT_CATEGORY_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
