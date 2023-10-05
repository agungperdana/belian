
package com.kratonsolution.belian.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.kratonsolution.belian.common.persistence.Referenceable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Models
{
	public static final Map<String, Referenceable> toRefMap(Collection<? extends Referenceable> col)
	{
		Map<String, Referenceable> maps = new HashMap<>();
		
		if(col != null)
		{
			for(Referenceable ref:col)
				maps.put(ref.getValue(), ref);
		}
		
		return maps;
	}
}
