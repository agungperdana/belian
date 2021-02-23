package com.kratonsolution.belian.party.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.party.api.PartyGeographicInfoData;
import com.kratonsolution.belian.party.impl.model.PartyGeographicInfo;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface PartyGeographicInfoMapper {
    
	PartyGeographicInfoMapper INSTANCE = Mappers.getMapper(PartyGeographicInfoMapper.class);
	
    PartyGeographicInfoData toData(@NonNull PartyGeographicInfo info);
    
    List<PartyGeographicInfoData> toDatas(@NonNull List<PartyGeographicInfo> infos);
}
