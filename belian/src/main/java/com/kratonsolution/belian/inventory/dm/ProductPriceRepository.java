/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ProductPriceRepository extends JpaRepository<ProductPrice, String>
{
	@Query(
			"FROM ProductPrice prd "
			+ "WHERE "
			+ "((:date BETWEEN prd.from AND prd.to) OR (:date >= prd.from AND prd.to IS NULL))"
			+ " AND "
			+ "prd.currency.id =:currency"
			+ " AND "
			+ "(prd.geographic IS NULL OR prd.geographic.id =:geo)"
			+ " AND "
			+ "(prd.party IS NULL OR prd.party.id =:party)"
			+ " AND "
			+ "prd.product.id =:product"
			+ " AND "
			+ "prd.type =:type")
	public List<ProductPrice> load(@Param("date")Date date,@Param("currency")String currency,
								   @Param("geo")String geo,@Param("party")String party,
								   @Param("product")String product,@Param("type")ProductPrice.Type type);
}
