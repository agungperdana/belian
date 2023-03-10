
package com.kratonsolution.belian.security.impl.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface RoleRepository extends JpaRepository<Role,String>
{
	public Role getOneByCode(String code);
	
	public Role getOneByName(String name);
}
