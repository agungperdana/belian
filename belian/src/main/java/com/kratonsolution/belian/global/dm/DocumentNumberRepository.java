/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kratonsolution.belian.global.dm.DocumentNumber.Type;

/**
 * @author agungdodiperdana
 *
 */
public interface DocumentNumberRepository extends MongoRepository<DocumentNumber, String>
{
	public DocumentNumber findOneByType(Type type);
}
