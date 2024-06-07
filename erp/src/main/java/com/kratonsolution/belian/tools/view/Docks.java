package com.kratonsolution.belian.tools.view;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface Docks {
	public void register(Dock dock);
	
	public void remove(Dock dock);
	
	public boolean contain(Dock dock);
}
