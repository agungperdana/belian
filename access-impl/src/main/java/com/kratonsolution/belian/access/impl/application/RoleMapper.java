package com.kratonsolution.belian.access.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.access.impl.model.Role;
import com.kratonsolution.belian.access.api.RoleData;

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
