/**
 * 
 */
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Getter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class FormToolbar extends Toolbar
{
	private Language lang = Springs.get(Language.class);
	
	private Toolbarbutton cancel = new Toolbarbutton(lang.get("label.component.button.cancel"),"/icons/cancel.png");
	
	private Toolbarbutton save = new Toolbarbutton(lang.get("label.component.button.save"),"/icons/save.png");
	
	private Toolbarbutton print = new Toolbarbutton(lang.get("label.component.button.print"),"/icons/print.png");
	
	private Toolbarbutton approve = new Toolbarbutton(lang.get("label.component.button.accept"),"/icons/approved.png");
	
	private Toolbarbutton reject = new Toolbarbutton(lang.get("label.component.button.reject"),"/icons/rejected.png");
	
	private Toolbarbutton pending = new Toolbarbutton(lang.get("label.component.button.pending"),"/icons/pending24.png");
	
	private Toolbarbutton review = new Toolbarbutton(lang.get("label.component.button.review"),"/icons/review24.png");
	
	private Toolbarbutton close = new Toolbarbutton(lang.get("label.component.button.close"),"/icons/close24.png");
	
	public FormToolbar()
	{
		setWidth("100%");
		setHeight("36px");
	
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
