package com.kratonsolution.belian.facility.impl.repository;

import java.util.List;

import com.kratonsolution.belian.facility.impl.orm.Facility;
import com.kratonsolution.belian.facility.impl.orm.FacilityOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface FacilityRepository extends JpaRepository<Facility, String>
{
	public Facility findByName(String name);
	
	public List<Facility> findAllByType(String type);
	
	@Query("FROM FacilityOrganization org WHERE "
			+ "org.organization.id =:company "
			+ "AND org.enabled IS TRUE "
			+ "ORDER BY org.organization.value ASC ")
	public List<FacilityOrganization> findAllFor(@Param("company")String organization);
}
