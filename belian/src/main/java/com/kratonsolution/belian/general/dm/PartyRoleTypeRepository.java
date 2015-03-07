/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface PartyRoleTypeRepository extends JpaRepository<PartyRoleType, String>
{
	public PartyRoleType findOneByName(String name);
}
