/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface AccessibleOrganizationRepository extends JpaRepository<AccessibleOrganization, String>
{
	@Query("FROM AccessibleOrganization org WHERE org.organization.id =:company")
	public List<AccessibleOrganization> findAllByOrganization(@Param("company")String organizationId);
}
