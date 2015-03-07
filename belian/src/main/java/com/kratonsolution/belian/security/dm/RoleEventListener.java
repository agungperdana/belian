/**
 * 
 */
package com.kratonsolution.belian.security.dm;

/**
 * @author agungdodiperdana
 *
 */
public interface RoleEventListener
{
	public void fireRoleRemoved(String id);
	
	public void fireRoleAdded(Role role);
}
