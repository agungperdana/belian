package com.kratonsolution.belian.productfeature.impl.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.kratonsolution.belian.productfeature.impl.orm.ProductFeature;
import com.kratonsolution.belian.productfeature.impl.repository.ProductFeatureRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ProductFeatureService
{
	@Autowired
	private ProductFeatureRepository repository;
	
	@Secured("ROLE_PRODUCT_FEATURE_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PRODUCT_FEATURE_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public ProductFeature findById(String id)
	{
		return repository.findById(id).orElse(null);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_FEATURE_READ")
	public List<ProductFeature> findAll()
	{
		return repository.findAll();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_FEATURE_READ")
	public List<ProductFeature> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_PRODUCT_FEATURE_CREATE")
	public void add(ProductFeature category)
	{
		repository.save(category);
	}
	
	@Secured("ROLE_PRODUCT_FEATURE_UPDATE")
	public void edit(ProductFeature category)
	{
		repository.saveAndFlush(category);
	}
	
	@Secured("ROLE_PRODUCT_FEATURE_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.deleteById(id);
	}
}
