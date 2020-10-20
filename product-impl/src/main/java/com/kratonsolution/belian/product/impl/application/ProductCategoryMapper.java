package com.kratonsolution.belian.product.impl.application;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kratonsolution.belian.product.api.ProductCategoryData;
import com.kratonsolution.belian.product.impl.model.ProductCategory;

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
