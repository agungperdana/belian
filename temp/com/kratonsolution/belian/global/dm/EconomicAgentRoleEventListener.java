/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import com.kratonsolution.belian.partys.dm.PartyRole;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface EconomicAgentRoleEventListener
{
	public void fireRoleAdded(PartyRole role);
	
	public void fireRoleRemoved(PartyRole role);
}
