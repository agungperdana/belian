/**
 * 
 */
package com.kratonsolution.belian.ui;

import com.kratonsolution.belian.inventory.dm.Facility;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ModelDataListener
{
	public void fireDataAdded(Facility facility);
	
	public void fireDataUpdated(Facility facility);
	
	public void fireDataRemoved(Facility facility);
}
