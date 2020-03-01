package com.kratonsolution.belian.impl.security.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.api.security.RoleData;
import com.kratonsolution.belian.impl.security.model.Role;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Mapper
public interface RoleMapper {
    
	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	
    RoleData toData(@NonNull Role role);
    
    List<RoleData> toRoleDatas(@NonNull List<Role> roles);
}
