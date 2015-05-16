/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author agungdodiperdana
 *
 */
public interface GLAccountRepository extends JpaRepository<GLAccount, String>
{
	@Query("FROM GLAccount account WHERE account.parent IS NULL ORDER BY account.number ASC")
	public List<GLAccount> findAllByParentIsNull();
	
	public List<GLAccount> findAllByParentIsNull(Pageable pageable);
	
	public List<GLAccount> findAllByParent(String id);
	
	public GLAccount findOneByName(String name);
	
	@Query("SELECT MAX(account.number) FROM GLAccount account WHERE account.type = ?1 ORDER BY account.number DESC")
	public Long lastNumber(GLAccount.Type type);
}
