/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface OrganizationAccountRepository extends JpaRepository<OrganizationAccount, String>
{
	@Query("FROM OrganizationAccount account WHERE account.organization.id = :org ")
	public List<OrganizationAccount> findAllByOrganization(@Param("org")String organization);

	public OrganizationAccount findOneByOrganizationId(String organization);
}
