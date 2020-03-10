package com.kratonsolution.belian.common.ui;

import org.zkoss.zul.Toolbarbutton;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ApplicationModule {

	public String getName();
	
	public String getFisheyesImage();
	
	public String getRegistryImage();
	
	public void open();

	public void show();
	
	public void hide();
	
	public void exit();
	
	public Toolbarbutton getRemoteControl();
}
