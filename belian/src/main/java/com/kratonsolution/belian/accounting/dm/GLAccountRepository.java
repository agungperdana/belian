/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface GLAccountRepository extends MongoRepository<GLAccount, String>
{
	public List<GLAccount> findAllByParentIsNull();
	
	public List<GLAccount> findAllByParentIsNull(Pageable pageable);
	
	public List<GLAccount> findAllByParent(String id);
	
	public GLAccount findOneByName(String name);
}
