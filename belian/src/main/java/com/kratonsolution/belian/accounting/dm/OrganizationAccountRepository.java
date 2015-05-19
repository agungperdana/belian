/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author agungdodiperdana
 *
 */
public interface OrganizationAccountRepository extends JpaRepository<OrganizationAccount, String>
{
	@Query("FROM OrganizationAccount account WHERE account.organization.id = :org ")
	public List<OrganizationAccount> findAllByOrganization(@Param("org")String organization);
}
