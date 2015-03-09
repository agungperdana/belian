/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface CurrencyRepository extends JpaRepository<Currency, String>
{
	public Currency findOneByCode(String code);
}
