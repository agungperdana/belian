/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface AccountingPeriodRepository extends MongoRepository<AccountingPeriod, String>
{
	public List<AccountingPeriod> findAllByParentIsNull();
}
