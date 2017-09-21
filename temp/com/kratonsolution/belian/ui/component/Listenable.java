/**
 * 
 */
package com.kratonsolution.belian.ui.component;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface Listenable<T extends ModelListener>
{
	public void addListener(T listener);
}
