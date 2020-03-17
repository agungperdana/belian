package com.kratonsolution.belian.security.ui.window;

import org.zkoss.zul.Window;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class UserWindow extends Window {

	private static final long serialVersionUID = 1L;

	public UserWindow() {

		setWidth("80%");
		setHeight("65%");
		setPosition("center");
		setTopmost();
		setClosable(true);
		setMinimizable(true);
		setMaximizable(true);
		setTitle("Security >> User >> Window");
	}
}
