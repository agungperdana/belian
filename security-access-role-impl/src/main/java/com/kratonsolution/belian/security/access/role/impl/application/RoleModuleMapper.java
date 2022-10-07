package com.kratonsolution.belian.security.access.role.impl.application;

import com.kratonsolution.belian.security.access.role.api.RoleModuleData;
import com.kratonsolution.belian.security.access.role.impl.domain.RoleModule;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface RoleModuleMapper {
    
	RoleModuleMapper INSTANCE = Mappers.getMapper(RoleModuleMapper.class);

    @Mappings({
            @Mapping(target = "name", source = "name.value"),
            @Mapping(target = "group", source = "group.value"),
            @Mapping(target = "read", source = "read.value"),
            @Mapping(target = "add", source = "add.value"),
            @Mapping(target = "edit", source = "edit.value"),
            @Mapping(target = "delete", source = "delete.value"),
            @Mapping(target = "print", source = "print.value")
    })
    RoleModuleData domainToData(@NonNull RoleModule domain);

    List<RoleModuleData> domainsToDatas(@NonNull List<RoleModule> domains);
}
