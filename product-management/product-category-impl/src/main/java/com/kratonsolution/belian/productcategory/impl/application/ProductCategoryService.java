package com.kratonsolution.belian.productcategory.impl.application;

import com.kratonsolution.belian.productcategory.impl.orm.ProductCategory;
import com.kratonsolution.belian.productcategory.impl.repository.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor=Exception.class)
@AllArgsConstructor
public class ProductCategoryService
{
	private ProductCategoryRepository repository;
	
	@Secured("ROLE_PRODUCT_CATEGORY_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PRODUCT_CATEGORY_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public ProductCategory findById(String id)
	{
		return repository.findById(id).orElse(null);
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
		return repository.findAll(PageRequest.of(pageIndex, pageSize)).getContent();
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
		repository.deleteById(id);
	}
}
