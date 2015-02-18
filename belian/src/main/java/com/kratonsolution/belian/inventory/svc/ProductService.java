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

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.inventory.dm.ProductRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class ProductService
{
	@Autowired
	private ProductRepository repository;
	
	@Secured("ROLE_PRODUCT_READ")
	public int size()
	{
		return Long.valueOf(repository.count()).intValue();
	}
	
	@Secured("ROLE_PRODUCT_READ")
	public Product findOne(String id)
	{
		return repository.findOne(id);
	}
	
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAll()
	{
		return repository.findAll();
	}
	
	@Secured("ROLE_PRODUCT_READ")
	public List<Product> findAll(int pageIndex,int pageSize)
	{
		return repository.findAll(new PageRequest(pageIndex, pageSize)).getContent();
	}
	
	@Secured("ROLE_PRODUCT_CREATE")
	public void add(Product currency)
	{
		repository.save(currency);
	}
	
	@Secured("ROLE_PRODUCT_UPDATE")
	public void edit(Product currency)
	{
		repository.save(currency);
	}
	
	@Secured("ROLE_PRODUCT_DELETE")
	public void delete(@PathVariable String id)
	{
		repository.delete(id);
	}
}
