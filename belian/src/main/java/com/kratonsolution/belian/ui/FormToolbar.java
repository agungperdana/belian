/**
 * 
 */
package com.kratonsolution.belian.ui;

import lombok.Getter;

import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

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
	
	private Toolbarbutton print = new Toolbarbutton("Print");
	
	public FormToolbar()
	{
		setWidth("100%");
		setLeft("0px");
		setHeight("20%");
		
		cancel.setImage("/icons/cancel.png");
		save.setImage("/icons/save.png");
		print.setImage("/icons/print.png");
	
		appendChild(cancel);
		appendChild(save);
		appendChild(print);
	}
}
