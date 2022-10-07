package com.kratonsolution.belian.security.access.user.impl.application;

import com.kratonsolution.belian.security.access.user.api.UserData;
import com.kratonsolution.belian.security.access.user.impl.domain.User;
import com.kratonsolution.belian.security.access.user.impl.entity.R2DBCUserEntity;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

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
	
    UserData entityToData(@NonNull R2DBCUserEntity entity);
    
    List<UserData> toDatas(@NonNull List<R2DBCUserEntity> entities);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "version", ignore = true),
            @Mapping(target = "name", source = "name.value"),
            @Mapping(target = "email", source = "email.value"),
            @Mapping(target = "enabled", source = "enabled.value"),
            @Mapping(target = "source", source = "source.value")
    })
    R2DBCUserEntity toEntity(@NonNull User domain);

    @Mappings({
            @Mapping(target = "name", source = "name.value"),
            @Mapping(target = "email", source = "email.value"),
            @Mapping(target = "enabled", source = "enabled.value"),
            @Mapping(target = "source", source = "source.value")
    })
    UserData dommainToData(@NonNull User domain);
}
