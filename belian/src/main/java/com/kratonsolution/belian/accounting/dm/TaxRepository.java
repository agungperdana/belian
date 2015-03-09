/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface TaxRepository extends JpaRepository<Tax, String>
{
	public Tax findOneByName(String name);
}
