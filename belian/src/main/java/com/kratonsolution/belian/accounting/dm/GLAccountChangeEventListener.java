/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

/**
 * @author agungdodiperdana
 *
 */
public interface GLAccountChangeEventListener
{
	public void fireObjectCreated(GLAccount account);
	
	public void fireObjectDeleted(String id);
}
