/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface RoleRepository extends JpaRepository<Role,String>
{
	public Role findOneByCode(String code);
	
	public Role findOneByName(String name);
}
