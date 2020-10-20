package com.kratonsolution.belian.product.api.application;

import java.util.List;

import com.kratonsolution.belian.product.api.ProductCategoryData;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public interface ProductCategoryService {

	public ProductCategoryData create(@NonNull ProductCategoryCreateCommand command);

	public ProductCategoryData update(@NonNull ProductCategoryUpdateCommand command);

	public ProductCategoryData delete(@NonNull ProductCategoryDeleteCommand command);

	public int count();

	public int count(@NonNull ProductCategoryFilter filter);

	public ProductCategoryData getById(@NonNull String id);

	public ProductCategoryData getByName(@NonNull String code);

	public List<ProductCategoryData> getAllProductCategorys();

	public List<ProductCategoryData> getAllProductCategorys(int page, int size);

	public List<ProductCategoryData> getAllProductCategorys(@NonNull ProductCategoryFilter filter, int page, int size);
}
