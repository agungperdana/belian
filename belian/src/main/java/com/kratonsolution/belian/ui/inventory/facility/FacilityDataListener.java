/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.facility;

import com.kratonsolution.belian.facility.dm.Facility;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface FacilityDataListener
{
	public void fireDataAdded(Facility facility);
	
	public void fireDataUpdated(Facility facility);
	
	public void fireDataRemoved(Facility facility);
}
