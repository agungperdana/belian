/**
 * 
 */
package com.kratonsolution.belian.ui.util;

import java.math.BigDecimal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

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
	
	public static final void setDefault(Listbox listbox)
	{
		if(!listbox.getChildren().isEmpty())
			listbox.setSelectedIndex(0);
	}
	
	public static final Listbox newSelect()
	{
		Listbox listbox = new Listbox();
		listbox.setMold("select");
		listbox.setWidth("100%");
		
		return listbox;
	}
	
	public static final Textbox readOnlyTextBox()
	{
		Textbox textbox = new Textbox();
		textbox.setWidth("100%");
		textbox.setReadonly(true);
		return textbox;
	}
	
	public static final Doublebox readOnlyDoubleBox()
	{
		Doublebox box = new Doublebox(0d);
		box.setWidth("100%");
		box.setReadonly(true);
		box.setStyle("text-align:right;");
		return box;
	}

	public static final boolean isEmpty(Listbox listbox)
	{
		if(listbox == null)
			return true;
		
		if(listbox.getChildren().isEmpty())
			return true;
		
		if(listbox.getSelectedCount() == 0)
			return true;
		
		return false;
	}
	
	public static final Checkbox readOnlyCheckbox()
	{
		Checkbox checkbox = new Checkbox();
		checkbox.setDisabled(true);
		
		return checkbox;
	}
	
	public static final Checkbox checkbox(boolean isChecked)
	{
		Checkbox checkbox = new Checkbox();
		checkbox.setChecked(isChecked);
		
		return checkbox;
	}
}
