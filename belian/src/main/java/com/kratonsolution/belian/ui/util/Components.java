/**
 * 
 */
package com.kratonsolution.belian.ui.util;

import java.math.BigDecimal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Listbox;

/**
 * @author agungdodiperdana
 *
 */
public class Components
{
	public static final String string(Listbox listbox)
	{
		if(listbox != null && !listbox.getChildren().isEmpty())
			return listbox.getSelectedItem().getValue().toString();
		
		return "";
	}
	
	public static final BigDecimal decimal(Component component)
	{
		if(component != null && (component instanceof Listbox) && !component.getChildren().isEmpty())
		{
			Listbox listbox = (Listbox)component;
			return new BigDecimal(listbox.getSelectedItem().getValue().toString());
		}
		else if(component != null && (component instanceof Doublebox))
		{
			Doublebox doublebox = (Doublebox)component;
			return BigDecimal.valueOf(doublebox.doubleValue());
		}
		
		return BigDecimal.ZERO;
	}
}
