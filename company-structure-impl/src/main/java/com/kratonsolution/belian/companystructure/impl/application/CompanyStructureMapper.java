package com.kratonsolution.belian.companystructure.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.companystructure.api.CompanyStructureData;
import com.kratonsolution.belian.companystructure.impl.model.CompanyStructure;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface CompanyStructureMapper {
    
	CompanyStructureMapper INSTANCE = Mappers.getMapper(CompanyStructureMapper.class);
	
    CompanyStructureData toData(@NonNull CompanyStructure company);
    
    List<CompanyStructureData> toDatas(@NonNull List<CompanyStructure> company);
}
