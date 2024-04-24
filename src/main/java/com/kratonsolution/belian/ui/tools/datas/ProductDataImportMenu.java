
package com.kratonsolution.belian.ui.tools.datas;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.kratonsolution.belian.ui.nav.AbstractMenuItem;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class ProductDataImportMenu extends AbstractMenuItem
{
	public ProductDataImportMenu()
	{
		setLabel(lang.get("navbar.menu.tools.product"));
		setImage("/icons/imports.png");
		addEventListener(Events.ON_CLICK, this);
	}
	
	@Override
	public void onEvent(Event arg0) throws Exception
	{
		System.out.println("click.......");
		
		ProductDataImportWindow window = new ProductDataImportWindow();
		window.setPage(getPage());
		window.doOverlapped();
	}
}