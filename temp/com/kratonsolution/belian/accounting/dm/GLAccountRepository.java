/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface GLAccountRepository extends JpaRepository<GLAccount, String>
{
	@Query("FROM GLAccount account WHERE account.parent IS NULL ORDER BY account.number ASC")
	public List<GLAccount> findAllByParentIsNull();
	
	@Query("SELECT COUNT(account) FROM GLAccount account WHERE account.parent IS NULL")
	public int countRoot();
	
	public List<GLAccount> findAllByParentIsNull(Pageable pageable);
	
	public List<GLAccount> findAllByParent(String id);
	
	public GLAccount findOneByName(String name);
	
	@Query("SELECT MAX(account.number) FROM GLAccount account WHERE account.type =:type ORDER BY account.number DESC")
	public Long lastNumber(@Param("type")GLAccountType type);
	
	public List<GLAccount> findAllByType(GLAccountType type);
}
