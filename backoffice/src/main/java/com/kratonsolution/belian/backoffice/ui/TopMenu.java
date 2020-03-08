package com.kratonsolution.belian.backoffice.ui;

import org.zkoss.zul.Menubar;

import com.kratonsolution.belian.backoffice.ui.menu.Belian;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class TopMenu extends Menubar
{
	private static final long serialVersionUID = 1L;

	private Belian belian = new Belian();

	public TopMenu() {
		
		setHflex("1");
		appendChild(belian);

	}

	public void clear() {
		
		getChildren().clear();
		appendChild(belian);
	}
}