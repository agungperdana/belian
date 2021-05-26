package com.kratonsolution.belian.access.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.access.api.ModuleData;
import com.kratonsolution.belian.access.impl.model.Module;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface ModuleMapper {
    
	ModuleMapper INSTANCE = Mappers.getMapper(ModuleMapper.class);
	
    ModuleData toData(@NonNull Module module);
    
    List<ModuleData> toDatas(@NonNull List<Module> modules);
}
