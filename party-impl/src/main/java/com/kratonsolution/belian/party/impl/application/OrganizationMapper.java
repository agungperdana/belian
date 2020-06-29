package com.kratonsolution.belian.party.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.party.api.OrganizationData;
import com.kratonsolution.belian.party.impl.model.Organization;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface OrganizationMapper {
    
	OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);
	
	@Mappings({
		@Mapping(source = "party.code", target = "code"),
		@Mapping(source = "party.name", target = "name"),
		@Mapping(source = "party.taxCode", target = "taxCode"),
		@Mapping(source = "party.birthDate", target = "birthDate"),
		@Mapping(source = "party.birthPlace", target = "birthPlace"),
		@Mapping(source = "party.addresses", target = "addresses"),
		@Mapping(source = "party.contacts", target = "contacts"),
		@Mapping(source = "party.partyRoles", target = "partyRoles"),
		@Mapping(source = "party.partyRelationships", target = "partyRelationships"),
		@Mapping(source = "party.partyClassifications", target = "partyClassifications")
	})
    OrganizationData toData(@NonNull Organization Organization);
    
    List<OrganizationData> toDatas(@NonNull List<Organization> organizations);
}
