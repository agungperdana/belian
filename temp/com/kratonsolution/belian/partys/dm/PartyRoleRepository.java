/**
 * 
 */
package com.kratonsolution.belian.partys.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PartyRoleRepository extends JpaRepository<PartyRole, String>
{
//	public PartyRole findOneByPartyIdAndType(String partyId,PartyRole.Type type);
}
