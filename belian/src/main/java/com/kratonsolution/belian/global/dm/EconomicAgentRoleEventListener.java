/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import com.kratonsolution.belian.general.dm.PartyRole;

/**
 * @author agungdodiperdana
 *
 */
public interface EconomicAgentRoleEventListener
{
	public void fireRoleAdded(PartyRole role);
	
	public void fireRoleRemoved(PartyRole role);
}
