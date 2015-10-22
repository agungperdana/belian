/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kratonsolution.belian.general.dm.Organization.IndustryType;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface OrganizationRepository extends JpaRepository<Organization, String>
{
	public List<Organization> findAllByType(IndustryType type);
}
