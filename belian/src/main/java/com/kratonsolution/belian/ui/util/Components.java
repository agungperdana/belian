/**
 * 
 */
package com.kratonsolution.belian.ui.util;

import java.math.BigDecimal;

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
	
	public static final BigDecimal decimal(Listbox listbox)
	{
		if(listbox != null && !listbox.getChildren().isEmpty())
			return new BigDecimal(listbox.getSelectedItem().getValue());
		
		return BigDecimal.ZERO;
	}
}
