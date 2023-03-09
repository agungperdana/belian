
package com.kratonsolution.belian.accounting.dm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface CurrencyRepository extends JpaRepository<Currency, String>
{
	public Currency getOneByCode(String code);

	@Query("FROM Currency cur WHERE cur.base = true")
	public Currency findDefault();
}
