package com.kratonsolution.belian.party.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.party.api.PartyRelationshipData;
import com.kratonsolution.belian.party.impl.model.PartyRelationship;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface PartyRelationshipMapper {
    
	PartyRelationshipMapper INSTANCE = Mappers.getMapper(PartyRelationshipMapper.class);
	
	@Mappings({
		@Mapping(source = "relationship.toParty.code", target = "toPartyCode"),
		@Mapping(source = "relationship.toParty.name", target = "toPartyName")
	})
	PartyRelationshipData toData(@NonNull PartyRelationship relationship);
    
    List<PartyRelationshipData> toDatas(@NonNull List<PartyRelationship> relationships);
}
