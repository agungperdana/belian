
package com.kratonsolution.belian.ui;

import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.app.Language;
import com.kratonsolution.belian.ui.util.Springs;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public abstract class Navigation extends Toolbar
{
	protected Language lang = Springs.get(Language.class);
	
	protected Toolbarbutton table = new Toolbarbutton(lang.get("nav.table"),"/icons/table32.png");
	
	protected Toolbarbutton form = new Toolbarbutton(lang.get("nav.form"),"/icons/form32.png");

	public Navigation()
	{
		setStyle("background-color:blackeel;font-size:10px;padding-top:5px;");
		setOrient("vertical");
		setWidth("65px");
		setVflex("1");
		
		table.setOrient("vertical");
		table.setStyle("text-align:center;font-size:9px;");
		table.setWidth("55px");
		table.setHeight("55px");
		
		form.setOrient("vertical");
		form.setStyle("text-align:center;font-size:9px;");
		form.setWidth("55px");
		form.setHeight("55px");
		
		appendChild(table);
		appendChild(form);
	}
	
	public abstract void setAddMode(boolean mode);
}
