/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface ProductRepository extends JpaRepository<Product, String>
{
	public Product findOneByName(String name);
	
	public List<Product> findAllByTypeNot(Product.Type type);
}
