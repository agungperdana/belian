/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface ModuleRepository extends JpaRepository<Module, String>
{
	public Module findOneByCode(String code);
	
	public Module findOneByName(String name);
}
