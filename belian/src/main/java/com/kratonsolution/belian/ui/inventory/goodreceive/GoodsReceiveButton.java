/**
 * 
 */
package com.kratonsolution.belian.ui.inventory.goodreceive;

import org.zkoss.zul.Toolbarbutton;

import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.ui.util.Springs;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class GoodsReceiveButton extends Toolbarbutton
{
	private Language lang = Springs.get(Language.class);
	
	public GoodsReceiveButton()
	{
		setImage("/icons/goods_receive.png");
		setHeight("38px");
		setTooltiptext(lang.get("navbar.menu.inventory.goodsreceive"));
	}
}
