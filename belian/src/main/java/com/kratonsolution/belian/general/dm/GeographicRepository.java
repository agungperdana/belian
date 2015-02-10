/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Agung Dodi Perdana
 *
 */
public interface GeographicRepository extends MongoRepository<Geographic, String> 
{
	public List<Geographic> findAllByType(Geographic.Type type);
}
