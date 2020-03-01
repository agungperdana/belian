package com.kratonsolution.belian.impl.security.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.api.security.RoleModuleData;
import com.kratonsolution.belian.impl.security.model.RoleModule;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Mapper
public interface RoleModuleMapper {
    
	RoleModuleMapper INSTANCE = Mappers.getMapper(RoleModuleMapper.class);
	
    RoleModuleData toData(@NonNull RoleModule module);
    
    List<RoleModuleData> toDatas(@NonNull List<RoleModule> modules);
}
