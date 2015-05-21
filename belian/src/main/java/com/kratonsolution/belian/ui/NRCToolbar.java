/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

/**
 * @author agungdodiperdana
 *
 */
public class NRCToolbar extends Toolbar
{
	public NRCToolbar()
	{
		setHeight("40px");
		appendChild(new Toolbarbutton("New","/icons/new.png"));
		appendChild(new Toolbarbutton("Remove","/icons/delete.png"));
		appendChild(new Toolbarbutton("Clear","/icons/refresh.png"));
	}
	
	public Component getNew()
	{
		return getChildren().get(0);
	}
	
	public Component getRemove()
	{
		return getChildren().get(1);
	}
	
	public Component getClear()
	{
		return getChildren().get(2);
	}
}
