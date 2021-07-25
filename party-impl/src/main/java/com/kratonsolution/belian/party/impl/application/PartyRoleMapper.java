package com.kratonsolution.belian.party.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.party.api.PartyRoleData;
import com.kratonsolution.belian.party.impl.model.PartyRole;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface PartyRoleMapper {
    
	PartyRoleMapper INSTANCE = Mappers.getMapper(PartyRoleMapper.class);
	
    PartyRoleData toData(@NonNull PartyRole partyRole);
    
    List<PartyRoleData> toDatas(@NonNull List<PartyRole> partyRoles);
}
