/**
 * 
 */
package com.kratonsolution.belian.security.dm;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface RoleEventListener
{
	public void fireRoleRemoved(String id);
	
	public void fireRoleAdded(Role role);
}
