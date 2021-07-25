package com.kratonsolution.belian.common.ui;

import org.zkoss.zul.Menu;
import org.zkoss.zul.Menupopup;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class AbstractMenu extends Menu
{
	private static final long serialVersionUID = 1L;

	protected Menupopup popup = new Menupopup();
	
	public boolean isDisabled() {
		return popup.getChildren().isEmpty();
	}
}
