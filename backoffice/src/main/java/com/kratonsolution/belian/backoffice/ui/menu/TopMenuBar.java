package com.kratonsolution.belian.backoffice.ui.menu;

import org.zkoss.zul.Menubar;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class TopMenuBar extends Menubar
{
	private static final long serialVersionUID = 1L;

	private Belian belian = new Belian();

	public TopMenuBar() {
		
		setHflex("1");
		appendChild(belian);

	}

	public void clear() {
		
		getChildren().clear();
		appendChild(belian);
	}
}