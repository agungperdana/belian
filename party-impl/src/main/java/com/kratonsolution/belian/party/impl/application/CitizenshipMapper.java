package com.kratonsolution.belian.party.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
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
	
	@Mappings({
		@Mapping(source = "citizenship.passport.number", target="passportNumber"),
		@Mapping(source = "citizenship.passport.issuedDate", target="passportIssuedDate"),
		@Mapping(source = "citizenship.passport.expirationDate", target="passportExpiredDate"),
		@Mapping(source = "citizenship.passport.country", target="passportCountry")
	})
    CitizenshipData toData(@NonNull Citizenship citizenship);
    
    List<CitizenshipData> toDatas(@NonNull List<Citizenship> citizenships);
}
