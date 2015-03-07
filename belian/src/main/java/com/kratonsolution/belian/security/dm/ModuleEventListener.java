/**
 * 
 */
package com.kratonsolution.belian.security.dm;

/**
 * @author agungdodiperdana
 *
 */
public interface ModuleEventListener
{
	public void fireModuleAdded(Module module);
	
	public void fireModuleRemoved(String id);
}
