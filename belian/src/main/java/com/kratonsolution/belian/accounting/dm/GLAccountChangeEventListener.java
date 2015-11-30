/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface GLAccountChangeEventListener
{
	public void fireObjectCreated(GLAccount account);
	
	public void fireObjectDeleted(String id);
}
