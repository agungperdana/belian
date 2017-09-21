/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface TaxRepository extends JpaRepository<Tax, String>
{
	public Tax findOneByName(String name);

	@Query("FROM Tax tx WHERE tx.base IS TRUE")
	public Tax findDefault();
}
