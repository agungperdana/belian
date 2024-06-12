
package com.kratonsolution.belian.product.impl.repository;

import java.util.List;

import com.kratonsolution.belian.product.impl.orm.PriceComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PriceComponentRepository extends JpaRepository<PriceComponent, String>
{
	@Query("FROM PriceComponent com WHERE "
			+ "com.product.id =:product "
			+ "AND (com.area IS NULL OR com.area.id IS NULL) "
			+ "AND (com.customer IS NULL OR com.customer.id IS NULL) "
			+ "AND (com.feature IS NULL OR com.feature.id IS NULL) "
			+ "ORDER BY com.product.name ASC ")
	public List<PriceComponent> findAllGeneral(@Param("product")String product);
	
	@Query("FROM PriceComponent com WHERE "
			+ "com.product.id =:product "
			+ "AND com.area.id IS NULL "
			+ "AND com.customer.id IS NULL "
			+ "AND com.feature.id =:feature "
			+ "ORDER BY com.product.name ASC ")
	public List<PriceComponent> findAll(@Param("product")String product,@Param("feature")String feature);
	
	@Query("FROM PriceComponent com WHERE "
			+ "com.product.id =:product "
			+ "AND com.area.id =:area "
			+ "AND com.customer.id IS NULL "
			+ "AND com.feature.id =:feature "
			+ "ORDER BY com.product.name ASC ")
	public List<PriceComponent> findAll(@Param("product")String product,
										@Param("feature")String feature,
										@Param("area")String area);
	
	@Query("FROM PriceComponent com WHERE "
			+ "com.product.id =:product "
			+ "AND com.area.id =:area "
			+ "AND com.customer.id =:customer "
			+ "AND com.feature.id =:feature "
			+ "ORDER BY com.product.name ASC ")
	public List<PriceComponent> findAll(@Param("product")String product,
										@Param("feature")String feature,
										@Param("area")String area,
										@Param("customer")String customer);

	@Query("FROM PriceComponent com WHERE "
			+ "com.product.id =:product "
			+ "AND com.area.id =:area "
			+ "AND com.customer.id =:customer "
			+ "AND com.feature.id IS NULL "
			+ "ORDER BY com.product.name ASC ")
	public List<PriceComponent> findAllANP(@Param("product")String product,
										@Param("area")String area,
										@Param("customer")String customer);
	
	@Query("FROM PriceComponent com WHERE "
			+ "com.product.id =:product "
			+ "AND com.area.id =:area "
			+ "AND com.customer.id IS NULL "
			+ "AND com.feature.id IS NULL "
			+ "ORDER BY com.product.name ASC ")
	public List<PriceComponent> findAllArea(@Param("product")String product,@Param("area")String area);
	
	@Query("FROM PriceComponent com WHERE "
			+ "com.product.id =:product "
			+ "AND com.area.id IS NULL "
			+ "AND com.customer.id =:customer "
			+ "AND com.feature.id IS NULL "
			+ "ORDER BY com.product.name ASC ")
	public List<PriceComponent> findAllParty(@Param("product")String product,@Param("customer")String customer);
}
