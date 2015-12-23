/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface BranchRepository extends JpaRepository<Branch, String>
{
	public Branch findOneByPartyId(String partyId);
}
