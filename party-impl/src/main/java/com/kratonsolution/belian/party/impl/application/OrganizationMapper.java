package com.kratonsolution.belian.party.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
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
	
    OrganizationData toData(@NonNull Organization Organization);
    
    List<OrganizationData> toDatas(@NonNull List<Organization> organizations);
}
