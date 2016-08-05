/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.familyfolder;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class FamilyFolderButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public FamilyFolderButton()
	{
		setImage("/icons/family_folder.png");
		setHeight("38px");
		setTooltiptext(lang.get("navbar.menu.healtcare.familyfolder"));
	}
}
