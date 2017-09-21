/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface Listable extends Serializable
{
	public String getLabel();
	
	public String getValue();
}
