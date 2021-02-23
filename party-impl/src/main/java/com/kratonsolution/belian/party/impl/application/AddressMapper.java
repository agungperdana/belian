package com.kratonsolution.belian.party.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.party.api.AddressData;
import com.kratonsolution.belian.party.impl.model.Address;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface AddressMapper {
    
	AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
	
    AddressData toData(@NonNull Address address);
    
    List<AddressData> toDatas(@NonNull List<Address> addresses);
}
