/**
 * 
 */
package com.kratonsolution.belian.ui.asset.asset;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class AssetButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public AssetButton()
	{
		setImage("/icons/asset.png");
		setTooltiptext(lang.get("navbar.menu.asset.asset"));
		setHeight("38px");
	}
}
