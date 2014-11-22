/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;


/**
 * @author Agung Dodi Perdana
 *
 */
public interface PartyRepository
{
	public Party findOne(String id);
	
	public List<Party> findAll();
	
	public List<Party> findAllByRole(String roleName);
}
