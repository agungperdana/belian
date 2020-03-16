package com.kratonsolution.belian.common.ui;

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
}