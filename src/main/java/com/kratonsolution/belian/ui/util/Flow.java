
package com.kratonsolution.belian.ui.util;

import java.util.Iterator;

import org.zkoss.zk.ui.Component;

import com.kratonsolution.belian.ui.Removeable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
public class Flow
{
	public static void next(Component parent,Component next)
	{
		if(parent != null)
		{
			Iterator<Component> iterator = parent.getChildren().iterator();
			while (iterator.hasNext())
			{
				Component com = (Component) iterator.next();
				if(com instanceof Removeable)
				{
					iterator.remove();
					break;
				}
			}
		}

		if(next != null)
			parent.appendChild(next);
	}
}
