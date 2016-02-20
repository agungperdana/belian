/**
 * 
 */
package com.kratonsolution.belian.ui.general.companystructure;

import com.kratonsolution.belian.general.dm.CompanyStructure;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface CompanyStructureDataListener
{
	public void fireDataAdded(CompanyStructure company);
	
	public void fireDataUpdated(CompanyStructure company);
	
	public void fireDataRemoved(CompanyStructure company);
}
