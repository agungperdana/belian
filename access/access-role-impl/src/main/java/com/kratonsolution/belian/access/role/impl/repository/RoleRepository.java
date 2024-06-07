package com.kratonsolution.belian.access.role.impl.repository;

import com.kratonsolution.belian.access.role.impl.orm.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface RoleRepository extends JpaRepository<Role,String>
{
	public Role findByCode(String code);

	public Role findByName(String name);
}
