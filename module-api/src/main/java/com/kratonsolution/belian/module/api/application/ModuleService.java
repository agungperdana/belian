package com.kratonsolution.belian.module.api.application;

import com.kratonsolution.belian.common.core.DataService;
import com.kratonsolution.belian.module.api.ModuleData;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 1.0.1
 */
public interface ModuleService extends DataService<CreateModuleCommand, UpdateModuleCommand, DeleteModuleCommand, ModuleQuery, ModuleData> {

}
