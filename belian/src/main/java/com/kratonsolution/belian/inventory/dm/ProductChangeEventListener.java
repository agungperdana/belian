/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ProductChangeEventListener
{
	public void fireObjectCreated(Product product);
	
	public void fireObjectDeleted(String productId);
}
