/**
 * 
 */
package com.kratonsolution.belian.inventory.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.inventory.dm.ProductCategory;
import com.kratonsolution.belian.inventory.dm.ProductCategoryRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class ProductCategoryService
{
	@Autowired
	private ProductCategoryRepository repository;
	
	@Secured("ROLE_PRDCATEGORY_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PRDCATEGORY_READ")
	public ProductCategory findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_PRDCATEGORY_READ")
	public List<ProductCategory> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_PRDCATEGORY_READ")
	public List<ProductCategory> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_PRDCATEGORY_CREATE")
	public void add(ProductCategory container)
	{
		repository.save(container);
	}
	
	@Secured("ROLE_PRDCATEGORY_UPDATE")
	public void edit(ProductCategory container)
	{
		repository.save(container);
	}
	
	@Secured("ROLE_PRDCATEGORY_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
