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
	public static String rowValue(Row row,int idex)
	{
		Label label = (Label)row.getChildren().get(idex);
		return label.getValue();
	}

	public static boolean isChecked(Row row,int idex)
	{
		Component component = row.getChildren().get(idex);
		if(component != null && component instanceof Checkbox)
			return ((Checkbox)component).isChecked();

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
