
package com.kratonsolution.belian.security.dm;

import com.kratonsolution.belian.security.svc.RoleService;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface RoleRepository extends JpaRepository<Role,String>
{
	public Role findByCode(String code);

	public Role findByName(String name);
}
