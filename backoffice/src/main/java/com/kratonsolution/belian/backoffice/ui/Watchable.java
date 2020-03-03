package com.kratonsolution.belian.backoffice.ui;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface Watchable
{
	public void open();
	
	public void kill();
	
	public String getName();
	
	public String getIcon();
	
	public Dock getDock();

	public boolean isVisible();
	
	public boolean setVisible(boolean visible);
	
	public boolean isAlive();
}
