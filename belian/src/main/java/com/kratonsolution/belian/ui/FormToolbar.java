/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

/**
 * @author agungdodiperdana
 *
 */
public class FormToolbar extends Toolbar
{
	private Toolbarbutton cancel = new Toolbarbutton("Cancel");
	
	private Toolbarbutton save = new Toolbarbutton("Save");
	
	public FormToolbar()
	{
		setWidth("100%");
		setLeft("0px");
		setHeight("20%");
		
		cancel.setImage("/icons/cancel.png");
		cancel.setParent(this);
		
		save.setImage("/icons/save.png");
		save.setParent(this);
	}
	
	public Toolbarbutton getCancel()
	{
		return this.cancel;
	}
	
	public Toolbarbutton getSave()
	{
		return this.save;
	}
}
