/**
 * 
 */
package com.kratonsolution.belian.ui.accounting.journalsetting;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class JournalSettingButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public JournalSettingButton()
	{
		setImage("/icons/accountingsetting.png");
		setTooltiptext(lang.get("navbar.menu.accounting.setting"));
		setHeight("38px");
	}
}
