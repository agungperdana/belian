package com.kratonsolution.belian.access.module.impl.application;

import com.kratonsolution.belian.access.module.impl.orm.Module;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface ModuleEventListener
{
	public void fireModuleAdded(Module module);
	
	public void fireModuleRemoved(String id);
}
