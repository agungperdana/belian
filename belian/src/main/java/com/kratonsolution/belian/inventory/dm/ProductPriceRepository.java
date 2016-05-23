/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.sql.Date;
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
								   @Param("product")String product,@Param("type")ProductPriceType type);

	@Query("FROM ProductPrice price "
			+ "WHERE "
			+ "((:date BETWEEN price.from AND price.to) OR (:date >= price.from AND price.to IS NULL)) "
			+ "AND price.currency.id =:currency "
			+ "AND price.product.id =:product "
			+ "AND price.type =:type")
	public List<ProductPrice> findAll(@Param("date")Date date,@Param("currency")String currency,@Param("product")String product,@Param("type")ProductPriceType type);
	
	@Query("FROM ProductPrice price "
			+ "WHERE "
			+ "((:date BETWEEN price.from AND price.to) OR (:date >= price.from AND price.to IS NULL)) "
			+ "AND price.currency.id =:currency "
			+ "AND price.product.id =:product "
			+ "AND price.type =:type "
			+ "AND price.geographic.id =:location")
	public List<ProductPrice> findAllWithLocation(@Param("date")Date date,@Param("location")String location,@Param("currency")String currency,@Param("product")String product,@Param("type")ProductPriceType type);
	
	@Query("FROM ProductPrice price "
			+ "WHERE "
			+ "((:date BETWEEN price.from AND price.to) OR (:date >= price.from AND price.to IS NULL)) "
			+ "AND price.currency.id =:currency "
			+ "AND price.product.id =:product "
			+ "AND price.type =:type "
			+ "AND price.party.id =:customer")
	public List<ProductPrice> findAllWithCustomer(@Param("date")Date date,@Param("customer")String customer,@Param("currency")String currency,@Param("product")String product,@Param("type")ProductPriceType type);
	
	@Query("FROM ProductPrice price "
			+ "WHERE "
			+ "((:date BETWEEN price.from AND price.to) OR (price.from <= :date AND price.to IS NULL)) "
			+ "AND price.currency.id =:currency "
			+ "AND price.product.id =:product "
			+ "AND price.type =:type "
			+ "AND price.party.id =:customer "
			+ "AND price.geographic.id =:location")
	public List<ProductPrice> findAll(@Param("date")Date date,@Param("location")String location,@Param("customer")String customer,@Param("currency")String currency,@Param("product")String product,@Param("type")ProductPriceType type);
}
