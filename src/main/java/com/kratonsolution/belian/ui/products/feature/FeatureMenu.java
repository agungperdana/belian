
package com.kratonsolution.belian.ui.products.feature;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class FeatureMenu extends AbstractMenuItem
{
	public FeatureMenu()
	{
		setLabel(lang.get("navbar.menu.products.feature"));
		setImage("/icons/feature16.png");
		setDisabled(!utils.getAccessibleModules().containsKey("ROLE_PRODUCT_FEATURE_READ"));
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		if(!kernel.isExist(getLabel()))
			kernel.open(FeatureWindow.newInstance(getPage()));
		else
			kernel.open(getLabel());
	}
}
