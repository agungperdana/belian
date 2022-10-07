package com.kratonsolution.belian.security.access.module.impl.application;

import com.kratonsolution.belian.security.access.module.api.ModuleData;
import com.kratonsolution.belian.security.access.module.impl.domain.AccessModule;
import com.kratonsolution.belian.security.access.module.impl.entity.R2DBCModuleEntity;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

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

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "version", ignore = true),
            @Mapping(target = "name", source = "name.value"),
            @Mapping(target = "group", source = "group.value"),
            @Mapping(target = "enabled", source = "enabled.value"),
            @Mapping(target = "description", source = "description.value")
    })
    R2DBCModuleEntity toEntity(@NonNull AccessModule domain);

    @Mappings({
            @Mapping(target = "name", source = "name.value"),
            @Mapping(target = "group", source = "group.value"),
            @Mapping(target = "enabled", source = "enabled.value"),
            @Mapping(target = "description", source = "description.value")
    })
    ModuleData toData(@NonNull AccessModule domain);
}
