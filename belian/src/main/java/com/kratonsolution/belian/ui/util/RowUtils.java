/**
 * 
 */
package com.kratonsolution.belian.ui.util;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

/**
 * @author agungdodiperdana
 *
 */
public class RowUtils
{
	public static String rowValue(Row row,int index)
	{
		Object object = row.getChildren().get(index);
		if(object != null && object instanceof Label)
			return ((Label)object).getValue();
		
		return "";
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
