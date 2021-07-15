package com.kratonsolution.belian.party.impl.application;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
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
	
	@Mappings({
		@Mapping(target = "partyRelationships", ignore = true),
		@Mapping(target = "birthPlace", ignore = true)
	})
    PartyData toData(@NonNull Party party);
    
    List<PartyData> toDatas(@NonNull List<Party> partys);
    
    @AfterMapping
    default void mapRelationship(@MappingTarget PartyData data, Party party) {
    	
    	party.getPartyRelationships().forEach(ob->{
    		
    		data.setBirthPlace(party.getName());
    		data.getPartyRelationships().add(PartyRelationshipMapper.INSTANCE.toData(ob));
    	});
    }
}
