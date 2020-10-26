package com.kratonsolution.belian.product.connector;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.product.api.ProductCategoryData;
import com.kratonsolution.belian.product.api.ProductCategoryRouteName;
import com.kratonsolution.belian.product.api.application.ProductCategoryCreateCommand;
import com.kratonsolution.belian.product.api.application.ProductCategoryDeleteCommand;
import com.kratonsolution.belian.product.api.application.ProductCategoryFilter;
import com.kratonsolution.belian.product.api.application.ProductCategoryService;
import com.kratonsolution.belian.product.api.application.ProductCategoryUpdateCommand;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */
@Service
@SuppressWarnings("unchecked")
public class ProductCategoryServiceProxy implements ProductCategoryService {

	@Autowired
	private ProducerTemplate producer;
	
	@Override
	public ProductCategoryData create(@NonNull ProductCategoryCreateCommand command) {

		return producer.requestBody(ProductCategoryRouteName.CRETATE, command, ProductCategoryData.class);
	}

	@Override
	public ProductCategoryData update(@NonNull ProductCategoryUpdateCommand command) {

		return producer.requestBody(ProductCategoryRouteName.UPDATE, command, ProductCategoryData.class);
	}

	@Override
	public ProductCategoryData delete(@NonNull ProductCategoryDeleteCommand command) {
		return producer.requestBody(ProductCategoryRouteName.DELETE, command, ProductCategoryData.class);
	}
	

	@Override
	public ProductCategoryData getByName(@NonNull String name) {
		return producer.requestBody(ProductCategoryRouteName.BY_NAME, name, ProductCategoryData.class);
	}

	@Override
	public ProductCategoryData getById(@NonNull String id) {
		return producer.requestBody(ProductCategoryRouteName.BY_ID, id, ProductCategoryData.class);
	}

	@Override
	public List<ProductCategoryData> getAllProductCategorys() {
		return producer.requestBody(ProductCategoryRouteName.GET_ALL, null, List.class);
	}

	@Override
	public List<ProductCategoryData> getAllProductCategorys(int page, int size) {
		return producer.requestBody(ProductCategoryRouteName.GET_ALL_WITH_PAGING, 
				new Object[] {Integer.valueOf(page), Integer.valueOf(size)}, List.class);
	}

	@Override
	public List<ProductCategoryData> getAllProductCategorys(@NonNull ProductCategoryFilter filter, int page, int size) {
		return producer.requestBody(ProductCategoryRouteName.GET_ALL_FILTER, 
				new Object[] {filter, Integer.valueOf(page), Integer.valueOf(size)}, List.class);
	}
	
	@Override
	public int count() {
		return producer.requestBody(ProductCategoryRouteName.COUNT, null, Integer.class);
	}

	@Override
	public int count(@NonNull ProductCategoryFilter filter) {
		return producer.requestBody(ProductCategoryRouteName.COUNT_FILTER, filter, Integer.class);
	}
}
