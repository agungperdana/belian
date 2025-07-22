
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface AcknowledgementItem extends Serializable
{
	public String getItemDescription();
	
	public String getOrderQuan();
	
	public String getMaxPrice();
}
