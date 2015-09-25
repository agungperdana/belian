/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kratonsolution.belian.general.dm.PartyRole.Type;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface OrganizationUnitRepository extends JpaRepository<OrganizationUnit, String>
{
	public List<OrganizationUnit> findAllByPartyId(String id);
	
	public OrganizationUnit findOneByPartyIdAndType(String partyId,Type type);
}
