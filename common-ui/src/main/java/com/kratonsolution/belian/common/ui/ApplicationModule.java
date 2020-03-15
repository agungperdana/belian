package com.kratonsolution.belian.common.ui;

import org.zkoss.zk.ui.Page;
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
	
	public void close();
	
	public Toolbarbutton getRemoteControl(Page page);
}