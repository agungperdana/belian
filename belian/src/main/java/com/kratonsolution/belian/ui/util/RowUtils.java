/**
 * 
 */
package com.kratonsolution.belian.ui.util;

import java.math.BigDecimal;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

/**
 * @author agungdodiperdana
 *
 */
public class RowUtils
{
	public static String string(Row row,int index)
	{
		Object object = row.getChildren().get(index);
		if(object != null)
		{
			if(object instanceof Label)
				return ((Label)object).getValue();
			else if(object instanceof Listbox)
				return Components.string((Listbox)object);
			else if(object instanceof Textbox)
				return ((Textbox)object).getText();
		}
		
		return "";
	}
	
	public static BigDecimal decimal(Row row,int index)
	{
		Object object = row.getChildren().get(index);
		if(object != null && object instanceof Doublebox)
			return BigDecimal.valueOf(((Doublebox)object).doubleValue());
		
		return BigDecimal.ZERO;
	}
	
	public static int integer(Row row,int index)
	{
		Object object = row.getChildren().get(index);
		if(object != null && object instanceof Doublebox)
			return ((Doublebox)object).getValue().intValue();
		
		return 0;
	}

	public static boolean isChecked(Row row,int idex)
	{
		Component component = row.getChildren().get(idex);
		if(component != null && component instanceof Checkbox)
			return ((Checkbox)component).isChecked();
		else if(component instanceof Label)
		{
			Label label = (Label)component;
			if(label.getValue().equals("Active"))
				return true;
		}
		
		return false;
	}

	public static void checked(Row row,int idex)
	{
		Component component = row.getChildren().get(idex);
		if(component != null && component instanceof Checkbox)
		{
			((Checkbox)component).setChecked(true);
		}
	}
	
	public static void unchecked(Row row,int idex)
	{
		Component component = row.getChildren().get(idex);
		if(component != null && component instanceof Checkbox)
		{
			((Checkbox)component).setChecked(false);
		}
	}
}
