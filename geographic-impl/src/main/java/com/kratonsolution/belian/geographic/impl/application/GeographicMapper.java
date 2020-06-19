package com.kratonsolution.belian.geographic.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.geographic.api.GeographicData;
import com.kratonsolution.belian.geographic.impl.model.Geographic;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface GeographicMapper {
    
	GeographicMapper INSTANCE = Mappers.getMapper(GeographicMapper.class);
	
	@Mapping(source = "parent.code", target="parent")
    GeographicData toData(@NonNull Geographic Geographic);
    
    List<GeographicData> toDatas(@NonNull List<Geographic> Geographics);
}
