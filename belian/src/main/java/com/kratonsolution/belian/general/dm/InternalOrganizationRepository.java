/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface InternalOrganizationRepository extends JpaRepository<InternalOrganization, String>
{
	public InternalOrganization findOneByPartyId(String id);
}
