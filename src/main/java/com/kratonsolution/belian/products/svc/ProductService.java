
package com.kratonsolution.belian.products.svc;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.google.common.base.Strings;
import com.kratonsolution.belian.products.dm.Product;
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
	public Product findByName(String name)
	{
		if(Strings.isNullOrEmpty(name))
			return null;
		
		return repository.getOneByName(name);
	}
	
	@Secured("ROLE_PRODUCT_READ")
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Product getOne(String id)
	{
		return repository.getOne(id);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAll()
	{
		return repository.findAll();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> byCategory(Collection<String> categorys)
	{
		return repository.byCategorys(categorys);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAll(String key)
	{
		return repository.findAll(key);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(PageRequest.of(pageIndex, pageSize)).getContent();
	}
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAll(int pageIndex,int pageSize,String key)
	{
		System.out.println(pageIndex);
		System.out.println(pageSize);
		System.out.println(key);
		
		if(!Strings.isNullOrEmpty(key))
			return repository.findAll(PageRequest.of(pageIndex, pageSize),key);
		
		return findAll(pageIndex,pageSize);
	}
	
	@Secured("ROLE_PRODUCT_CREATE")
	public void add(Product product)
	{
		product.setId(UUID.randomUUID().toString());
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
		repository.deleteById(id);
	}
}
