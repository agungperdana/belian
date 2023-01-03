package com.kratonsolution.belian.security.access.user.impl.application;

import com.google.gson.Gson;
import com.kratonsolution.belian.security.access.user.api.UserData;
import com.kratonsolution.belian.security.access.user.api.UserRoleData;
import com.kratonsolution.belian.security.access.user.impl.domain.User;
import com.kratonsolution.belian.security.access.user.impl.domain.UserRole;
import com.kratonsolution.belian.security.access.user.impl.entity.R2DBCUserEntity;
import io.r2dbc.postgresql.codec.Json;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0.1
 */
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "roles", qualifiedByName = "jsonToList")
    })
    UserData entityToData(R2DBCUserEntity entity);

    List<UserData> toDatas(List<R2DBCUserEntity> entities);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "version", ignore = true),
            @Mapping(target = "name", source = "name.value"),
            @Mapping(target = "email", source = "email.value"),
            @Mapping(target = "enabled", source = "enabled.value"),
            @Mapping(target = "source", source = "source.value"),
            @Mapping(target = "roles", qualifiedByName = "listToJson")
    })
    R2DBCUserEntity toEntity(User domain);

    @Named("listToJson")
    default Json listToJson(List<UserRole> roles) {

        if(roles != null) {
            return Json.of(new Gson().toJson(roles));
        }

        return null;
    }

    @Named("jsonToList")
    default List<UserRoleData> jsonToList(Json json) {

        List<UserRoleData> roles = new ArrayList<>();

        if(json != null) {
            roles.addAll(new Gson().fromJson(json.asString(), roles.getClass()));
        }

        return roles;
    }
}
