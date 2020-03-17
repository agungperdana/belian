package com.kratonsolution.belian.common.ui;

import org.zkoss.zul.Vbox;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public abstract class AbstractScreen extends Vbox {
	
	private static final long serialVersionUID = 1L;

	public abstract void init();
	
	public abstract Fisheyes getFisheye();
}
