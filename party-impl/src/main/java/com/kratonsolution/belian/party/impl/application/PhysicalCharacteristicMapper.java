package com.kratonsolution.belian.party.impl.application;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.party.api.PhysicalCharacteristicData;
import com.kratonsolution.belian.party.impl.model.PhysicalCharacteristic;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface PhysicalCharacteristicMapper {
    
	PhysicalCharacteristicMapper INSTANCE = Mappers.getMapper(PhysicalCharacteristicMapper.class);
	
    PhysicalCharacteristicData toData(@NonNull PhysicalCharacteristic physicalCharacteristic);
    
    List<PhysicalCharacteristicData> toDatas(@NonNull Collection<PhysicalCharacteristic> physicalCharacteristics);
}
