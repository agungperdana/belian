/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface OrganizationPeriodRepository extends JpaRepository<OrganizationPeriod, String>
{
	@Query("FROM OrganizationPeriod period WHERE "
			+ "period.organization.id =:company "
			+ "AND period.period.id =:period ")
	public OrganizationPeriod findOne(@Param("company")String company,@Param("period")String period);
}
