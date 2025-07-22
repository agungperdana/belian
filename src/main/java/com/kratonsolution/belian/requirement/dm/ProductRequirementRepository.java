
package com.kratonsolution.belian.requirement.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ProductRequirementRepository	extends JpaRepository<ProductRequirement, String>
{
	@Query("FROM ProductRequirement product WHERE "
			+ "product.organization.id =:company "
			+ "ORDER BY product.creationDate DESC ")
	public List<ProductRequirement> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(product) FROM ProductRequirement product WHERE "
			+ "product.organization.id =:company ")
	public Long count(@Param("company")String company);
	
	@Query("SELECT DISTINCT product FROM ProductRequirement product INNER JOIN product.statuses st WHERE "
			+ "st.type = 'ACTIVE' "
			+ "ORDER BY product.number ASC, product.creationDate DESC")
	public List<ProductRequirement> findAllOpen();
	
	@Query("SELECT DISTINCT emp FROM ProductRequirement emp INNER JOIN emp.statuses stat INNER JOIN emp.roles role WHERE "
			+ "emp.organization.id =:company "
			+ "AND stat.type = 'ACTIVE' "
			+ "AND role.type = 'INITIATOR' "
			+ "AND role.party.id =:initiator "
			+ "AND emp.product.id =:product "
			+ "AND emp.type =:type "
			+ "ORDER BY emp.creationDate ASC, emp.number ASC")
	public List<ProductRequirement> findAllProductActive( @Param("company")String company,
											@Param("initiator")String initiator,
											@Param("product")String product,
											@Param("type")RequirementType type);
	
	@Query("SELECT DISTINCT emp FROM ProductRequirement emp INNER JOIN emp.statuses stat WHERE "
			+ "emp.organization.id =:company "
			+ "AND stat.type = 'ACTIVE' "
			+ "AND emp.product.id =:product "
			+ "AND emp.type =:type "
			+ "ORDER BY emp.creationDate ASC, emp.number ASC")
	public List<ProductRequirement> findAllProductActive(@Param("company")String company,
														 @Param("product")String product,
														 @Param("type")RequirementType type);
	
	@Query("SELECT DISTINCT emp FROM ProductRequirement emp INNER JOIN emp.statuses stat INNER JOIN emp.roles role WHERE "
			+ "emp.organization.id =:company "
			+ "AND stat.type = 'ACTIVE' "
			+ "AND role.type = 'INITIATOR' "
			+ "AND role.party.id =:initiator "
			+ "AND emp.feature.id =:feature "
			+ "AND emp.type =:type "
			+ "ORDER BY emp.creationDate ASC, emp.number ASC")
	public List<ProductRequirement> findAllFeatureActive(@Param("company")String company,
														 @Param("initiator")String initiator,
														 @Param("feature")String feature,
														 @Param("type")RequirementType type);
	
	@Query("SELECT DISTINCT emp FROM ProductRequirement emp INNER JOIN emp.statuses stat WHERE "
			+ "emp.organization.id =:company "
			+ "AND stat.type = 'ACTIVE' "
			+ "AND emp.feature.id =:feature "
			+ "AND emp.type =:type "
			+ "ORDER BY emp.creationDate ASC, emp.number ASC")
	public List<ProductRequirement> findAllFeatureActive(@Param("company")String company,
														 @Param("feature")String feature,
														 @Param("type")RequirementType type);
}
