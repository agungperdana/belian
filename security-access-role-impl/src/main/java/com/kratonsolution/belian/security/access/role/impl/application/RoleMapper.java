package com.kratonsolution.belian.security.access.role.impl.application;

import com.google.common.base.Strings;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.kratonsolution.belian.security.access.role.api.RoleData;
import com.kratonsolution.belian.security.access.role.api.RoleModuleData;
import com.kratonsolution.belian.security.access.role.impl.domain.AccessRole;
import com.kratonsolution.belian.security.access.role.impl.domain.Modules;
import com.kratonsolution.belian.security.access.role.impl.domain.RoleModule;
import com.kratonsolution.belian.security.access.role.impl.entity.R2DBCRoleEntity;
import io.r2dbc.postgresql.codec.Json;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Mappings({
            @Mapping(target = "modules", source = "modules", qualifiedByName = "jsonToModules")
    })
    RoleData toData(@NonNull R2DBCRoleEntity role);

    List<RoleData> toDataList(List<R2DBCRoleEntity> roles);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "version", ignore = true),
            @Mapping(target = "name", source = "name.value"),
            @Mapping(target = "enabled", source = "enabled.value"),
            @Mapping(target = "description", source = "description.value"),
            @Mapping(target = "modules", source = "modules", qualifiedByName = "modulesToJson")
    })
    R2DBCRoleEntity domainToEntity(AccessRole domain);

    List<R2DBCRoleEntity> domainsToEntitys(Collection<AccessRole> domains);

    @Mappings({
            @Mapping(target = "name", source = "name.value"),
            @Mapping(target = "enabled", source = "enabled.value"),
            @Mapping(target = "description", source = "description.value"),
            @Mapping(target = "modules", source = "modules", qualifiedByName = "modulesToDatas")
    })
    RoleData domainToData(AccessRole domain);

    @Named("modulesToJson")
    default Json modulesToJson(Modules modules) {

        if(modules != null) {
            return Json.of(new Gson().toJson(modules));
        }

        return null;
    }

    @Named("jsonToModules")
    default List<RoleModuleData> jsonToModules(Json modulesJson) {

        if(modulesJson != null) {

            Modules modules = new Gson().fromJson(modulesJson.asString(), Modules.class);
            return RoleModuleMapper.INSTANCE.domainsToDatas(modules.getValue());
        }

        return new ArrayList<>();
    }

    @Named("modulesToDatas")
    default List<RoleModuleData> modulesToDatas(Modules modules) {

        if(modules != null) {
            return RoleModuleMapper.INSTANCE.domainsToDatas(modules.getValue());
        }

        return new ArrayList<>();
    }
}
