package com.kratonsolution.belian.products.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.products.api.ProductCategoryData;
import com.kratonsolution.belian.products.impl.model.ProductCategory;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Mapper
public interface ProductCategoryMapper {
    
	ProductCategoryMapper INSTANCE = Mappers.getMapper(ProductCategoryMapper.class);
	
    ProductCategoryData toData(@NonNull ProductCategory ProductCategory);
    
    List<ProductCategoryData> toDatas(@NonNull List<ProductCategory> ProductCategorys);
}
