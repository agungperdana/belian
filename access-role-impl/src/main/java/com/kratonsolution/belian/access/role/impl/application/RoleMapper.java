package com.kratonsolution.belian.access.role.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.access.role.api.RoleData;
import com.kratonsolution.belian.access.role.impl.model.Role;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface RoleMapper {
    
	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	
    RoleData toData(@NonNull Role role);
    
    List<RoleData> toRoleDatas(@NonNull List<Role> roles);
}