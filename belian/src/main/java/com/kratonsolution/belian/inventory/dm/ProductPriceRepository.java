/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ProductPriceRepository extends JpaRepository<ProductPrice, String>
{
	@Query(
			"FROM ProductPrice prd "
			+ "WHERE "
			+ "((:date BETWEEN prd.from AND prd.to) || (:date >= prd.from AND prd.to IS NULL))"
			+ " AND "
			+ "prd.currency.id =:currency"
			+ " AND "
			+ "(prd.geographic IS NULL || prg.geographic.id =:geo)"
			+ " AND "
			+ "(prd.party IS NULL || prd.party.id =:party)"
			+ " AND "
			+ "prd.product.id =:product")
	public List<ProductPrice> load(Date date,String currency,String geo,String party,String product);
}
