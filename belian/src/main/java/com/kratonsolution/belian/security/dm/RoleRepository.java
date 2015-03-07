/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface RoleRepository extends JpaRepository<Role,String>
{
	public Role findOneByCode(String code);
	
	public Role findOneByName(String name);
}
