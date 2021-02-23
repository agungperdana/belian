package com.kratonsolution.belian.party.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.party.api.PartyClassificationData;
import com.kratonsolution.belian.party.impl.model.PartyClassification;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface PartyClassificationMapper {
    
	PartyClassificationMapper INSTANCE = Mappers.getMapper(PartyClassificationMapper.class);
	
    PartyClassificationData toData(@NonNull PartyClassification classification);
    
    List<PartyClassificationData> toDatas(@NonNull List<PartyClassification> classifications);
}
