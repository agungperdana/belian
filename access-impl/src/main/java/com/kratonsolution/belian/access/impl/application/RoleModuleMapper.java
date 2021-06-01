package com.kratonsolution.belian.access.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.access.api.RoleModuleData;
import com.kratonsolution.belian.access.impl.model.RoleModule;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface RoleModuleMapper {
    
	RoleModuleMapper INSTANCE = Mappers.getMapper(RoleModuleMapper.class);
	
    RoleModuleData toData(@NonNull RoleModule module);
    
    List<RoleModuleData> toDatas(@NonNull List<RoleModule> modules);
}
