package com.kratonsolution.belian.party.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.party.api.PartyData;
import com.kratonsolution.belian.party.impl.model.Party;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface PartyMapper {
    
	PartyMapper INSTANCE = Mappers.getMapper(PartyMapper.class);
	
    PartyData toData(@NonNull Party party);
    
    List<PartyData> toDatas(@NonNull List<Party> partys);
}
