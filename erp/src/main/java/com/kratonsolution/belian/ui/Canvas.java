
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Vlayout;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Canvas extends Vlayout
{
	public Canvas()
	{
		setHflex("1");
		setVflex("1");
	}
	
	public void clear()
	{
		getChildren().clear();
	}
}
