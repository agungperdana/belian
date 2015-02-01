/**
 * 
 */
package com.kratonsolution.belian.ui.nav;

import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

/**
 * @author agungdodiperdana
 *
 */
public class Utils
{
	public static String rowValue(Row row,int idex)
	{
		Label label = (Label)row.getChildren().get(idex);
		return label.getValue();
	}
}
