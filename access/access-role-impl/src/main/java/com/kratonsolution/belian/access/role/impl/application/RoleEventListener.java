package com.kratonsolution.belian.access.role.impl.application;

import com.kratonsolution.belian.access.role.impl.orm.Role;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since  0.0.1
 */
public interface RoleEventListener
{
	public void fireRoleRemoved(String id);
	
	public void fireRoleAdded(Role role);
}
