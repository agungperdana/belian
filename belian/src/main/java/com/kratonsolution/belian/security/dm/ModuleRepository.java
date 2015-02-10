/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface ModuleRepository extends MongoRepository<Module, String>
{
	public Module findOneByCode(String code);
	
	public Module findOneByName(String name);
	
	public List<Module> findAllByDeleted(boolean isDeleted);
	
	public List<Module> findAllByDeleted(boolean isDeleted,Pageable pageable);
}
