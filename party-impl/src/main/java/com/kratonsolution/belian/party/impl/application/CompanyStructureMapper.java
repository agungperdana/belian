package com.kratonsolution.belian.party.impl.application;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.party.api.CompanyStructureData;
import com.kratonsolution.belian.party.impl.model.CompanyStructure;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface CompanyStructureMapper {
    
	CompanyStructureMapper INSTANCE = Mappers.getMapper(CompanyStructureMapper.class);
	
	@Mappings({
		@Mapping(target = "title", ignore = true),
		@Mapping(target = "key", ignore = true)
	})
    CompanyStructureData toData(@NonNull CompanyStructure com);
    
    List<CompanyStructureData> toDatas(@NonNull List<CompanyStructure> coms);
    
    @AfterMapping
    default void setTitleAndKey(@MappingTarget CompanyStructureData data, CompanyStructure com) {

    	data.setTitle(com.getCode()+"-"+com.getName());
    	data.setKey(com.getCode());
    }

}
