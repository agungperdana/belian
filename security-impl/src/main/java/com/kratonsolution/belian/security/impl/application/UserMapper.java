package com.kratonsolution.belian.security.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.security.api.UserData;
import com.kratonsolution.belian.security.api.UserRoleData;
import com.kratonsolution.belian.security.impl.model.User;
import com.kratonsolution.belian.security.impl.model.UserRole;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface UserMapper {
    
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
    UserData toData(@NonNull User user);
    
    List<UserData> toDatas(@NonNull List<User> users);
    
    UserRoleData toRoleData(@NonNull UserRole userRole);

    List<UserRoleData> toRoleDatas(@NonNull List<UserRole> userRoles);
}
