package com.kratonsolution.belian.security.ui;

import org.zkoss.zul.Window;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class ModuleWindow extends Window {

	private static final long serialVersionUID = 1L;

	public ModuleWindow() {
		
		setWidth("80%");
		setHeight("65%");
		setPosition("center");
		setTopmost();
		setClosable(true);
		setMinimizable(true);
		setMaximizable(true);
		setTitle("Security >> Module >> Window");
	}
}
