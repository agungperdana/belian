package com.kratonsolution.belian.party.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.party.api.CitizenshipData;
import com.kratonsolution.belian.party.impl.model.Citizenship;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface CitizenshipMapper {
    
	CitizenshipMapper INSTANCE = Mappers.getMapper(CitizenshipMapper.class);
	
    CitizenshipData toData(@NonNull Citizenship citizenship);
    
    List<CitizenshipData> toDatas(@NonNull List<Citizenship> citizenships);
}
