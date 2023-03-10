
package com.kratonsolution.belian.security.impl.dm;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ModuleEventListener
{
	public void fireModuleAdded(Module module);
	
	public void fireModuleRemoved(String id);
}
