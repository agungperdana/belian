package com.kratonsolution.belian.impl.security.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.api.security.ModuleData;
import com.kratonsolution.belian.impl.security.model.Module;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Mapper
public interface ModuleMapper {
    
	ModuleMapper INSTANCE = Mappers.getMapper(ModuleMapper.class);
	
    ModuleData toData(@NonNull Module module);
    
    List<ModuleData> toDatas(@NonNull List<Module> modules);
}
