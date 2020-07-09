package com.kratonsolution.belian.security.api.application;

import java.util.List;

import com.kratonsolution.belian.security.api.ModuleData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
public interface ModuleService {
   
    ModuleData create(@NonNull ModuleCreateCommand command);
    
    ModuleData update(@NonNull ModuleUpdateCommand command);
    
    ModuleData delete(@NonNull ModuleDeleteCommand command);

    ModuleData getByCode(@NonNull String code);
    
    List<ModuleData> getAllModules();
    
    List<ModuleData> getAllModules(int page, int size);
    
    List<ModuleData> getAllModules(@NonNull ModuleFilter filter, int page, int size);
    
    int count();
    
    int count(@NonNull ModuleFilter filter);
}
