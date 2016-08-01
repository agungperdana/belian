/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface OGLAccountRepository extends JpaRepository<OGLAccount, String>
{
	@Query("FROM OGLAccount account WHERE "
			+ "account.parent.id =:company "
			+ "AND account.selected IS TRUE "
			+ "ORDER BY account.account.number,account.account.name ASC")
	public List<OGLAccount> findAllSelected(@Param("company")String company);
}
