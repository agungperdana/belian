package com.kratonsolution.belian.impl.security.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.impl.security.model.User;
import com.kratonsolution.belian.impl.security.model.UserRole;
import com.kratonsolution.belian.api.security.UserData;
import com.kratonsolution.belian.api.security.UserRoleData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Mapper
public interface UserMapper {
    
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
    UserData toData(@NonNull User user);
    
    List<UserData> toDatas(@NonNull List<User> users);
    
    @Mapping(source = "role.code", target = "roleCode")
    UserRoleData toRoleData(@NonNull UserRole userRole);

    List<UserRoleData> toRoleDatas(@NonNull List<UserRole> userRoles);
}
