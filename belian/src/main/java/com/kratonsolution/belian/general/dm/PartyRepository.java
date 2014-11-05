/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;


/**
 * @author agungdodiperdana
 *
 */
public interface PartyRepository
{
	public Party findOne(String id);
	
	public List<Party> findAll();
}
