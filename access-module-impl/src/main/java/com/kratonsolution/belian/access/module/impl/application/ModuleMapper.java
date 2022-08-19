package com.kratonsolution.belian.access.module.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.access.module.api.ModuleData;
import com.kratonsolution.belian.access.module.impl.entity.R2DBCModuleEntity;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface ModuleMapper {
    
	ModuleMapper INSTANCE = Mappers.getMapper(ModuleMapper.class);
	
    ModuleData toData(@NonNull R2DBCModuleEntity module);
    
    List<ModuleData> toDatas(@NonNull List<R2DBCModuleEntity> modules);
}
