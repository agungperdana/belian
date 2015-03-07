/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kratonsolution.belian.general.dm.Organization.IndustryType;

/**
 * @author agungdodiperdana
 *
 */
public interface OrganizationRepository extends JpaRepository<Organization, String>
{
	public List<Organization> findAllByRolesTypeName(String roleName);
	
	public List<Organization> findAllByRelationshipsRelationshipTypeName(String name);

	public List<Organization> findAllByType(IndustryType type);
}
