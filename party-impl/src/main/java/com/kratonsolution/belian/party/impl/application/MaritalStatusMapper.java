package com.kratonsolution.belian.party.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.party.api.MaritalStatusData;
import com.kratonsolution.belian.party.impl.model.MaritalStatus;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface MaritalStatusMapper {
    
	MaritalStatusMapper INSTANCE = Mappers.getMapper(MaritalStatusMapper.class);
	
    MaritalStatusData toData(@NonNull MaritalStatus maritalStatus);
    
    List<MaritalStatusData> toDatas(@NonNull List<MaritalStatus> maritalStatuses);
}
