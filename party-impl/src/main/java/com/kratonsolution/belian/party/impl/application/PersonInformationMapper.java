package com.kratonsolution.belian.party.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.party.api.PersonInformationData;
import com.kratonsolution.belian.party.impl.model.PersonInformation;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface PersonInformationMapper {
    
	PersonInformationMapper INSTANCE = Mappers.getMapper(PersonInformationMapper.class);
	
    PersonInformationData toData(@NonNull PersonInformation personInformation);
    
    List<PersonInformationData> toDatas(@NonNull List<PersonInformation> personInformations);
}
