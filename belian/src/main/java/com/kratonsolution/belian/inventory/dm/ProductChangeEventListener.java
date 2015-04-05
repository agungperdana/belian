/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

/**
 * @author agungdodiperdana
 *
 */
public interface ProductChangeEventListener
{
	public void fireObjectCreated(Product product);
	
	public void fireObjectDeleted(String productId);
}
