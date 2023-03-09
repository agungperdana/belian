
package com.kratonsolution.belian.inventory.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface FacilityRepository extends JpaRepository<Facility, String>
{
	public Facility getOneByName(String name);
	
	public List<Facility> findAllByType(String type);
	
	@Query("FROM FacilityOrganization org WHERE "
			+ "org.organization.id =:company "
			+ "AND org.enabled = true "
			+ "ORDER BY org.organization.value ASC ")
	public List<FacilityOrganization> findAllFor(@Param("company")String organization);
}
