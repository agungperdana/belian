package com.kratonsolution.belian.backoffice.ui;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface Docks
{
	public void register(Dock dock);
	
	public void unregister(Dock dock);
	
	public boolean contain(Dock dock);
}
