/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import lombok.Getter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class FormToolbar extends Toolbar
{
	private Toolbarbutton cancel = new Toolbarbutton("Cancel");
	
	private Toolbarbutton save = new Toolbarbutton("Save");
	
	private Toolbarbutton print = new Toolbarbutton("Print","/icons/print.png");
	
	public FormToolbar()
	{
		setWidth("100%");
		setLeft("0px");
		setHeight("20%");
		
		cancel.setImage("/icons/cancel.png");
		save.setImage("/icons/save.png");
	
		appendChild(cancel);
		appendChild(save);
	}
	
	public void attachPrint()
	{
		appendChild(print);
	}
	
	public void disbaled()
	{
		cancel.setDisabled(true);
		save.setDisabled(true);
	}
	
	public void enabled()
	{
		cancel.setDisabled(false);
		save.setDisabled(false);
	}
}
