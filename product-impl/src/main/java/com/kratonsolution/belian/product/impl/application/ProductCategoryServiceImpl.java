package com.kratonsolution.belian.product.impl.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.product.api.ProductCategoryData;
import com.kratonsolution.belian.product.api.application.ProductCategoryCreateCommand;
import com.kratonsolution.belian.product.api.application.ProductCategoryDeleteCommand;
import com.kratonsolution.belian.product.api.application.ProductCategoryFilter;
import com.kratonsolution.belian.product.api.application.ProductCategoryService;
import com.kratonsolution.belian.product.api.application.ProductCategoryUpdateCommand;
import com.kratonsolution.belian.product.impl.model.ProductCategory;
import com.kratonsolution.belian.product.impl.repository.ProductCategoryRepository;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryRepository repo;
	
	@Override
	public ProductCategoryData create(@NonNull ProductCategoryCreateCommand command) {
		
		ProductCategory prod = new ProductCategory(command.getName(), command.getComment());
		
		if(!Strings.isNullOrEmpty(command.getParentName())) {
			
			prod.setParent(repo.findOneByName(command.getParentName()));
		}
		
		repo.save(prod);
		log.info("creating new Product category {}", prod);
		
		return ProductCategoryMapper.INSTANCE.toData(prod);
	}

	@Override
	public ProductCategoryData update(@NonNull ProductCategoryUpdateCommand command) {

		if(!Strings.isNullOrEmpty(command.getParentName()) || !Strings.isNullOrEmpty(command.getComment())) {
		
			ProductCategory prod = repo.findOneByName(command.getName());
			if(prod != null) {
				
				prod.setComment(command.getComment());
				
				if(!Strings.isNullOrEmpty(command.getParentName())) {
					prod.setParent(repo.findOneByName(command.getParentName()));
				}
				
				repo.save(prod);
				log.info("Updating Product Category {}", prod);
				
				return ProductCategoryMapper.INSTANCE.toData(prod);
			}
		}
		
		return ProductCategoryMapper.INSTANCE.toData(null);
	}

	@Override
	public ProductCategoryData delete(@NonNull ProductCategoryDeleteCommand command) {
		
		ProductCategory prod = repo.findOneByName(command.getName());
		if(prod != null) {
			
			repo.delete(prod);
		}
		
		return ProductCategoryMapper.INSTANCE.toData(prod);
	}

	@Override
	public int count() {
		return Long.valueOf(repo.count()).intValue();
	}

	@Override
	public int count(@NonNull ProductCategoryFilter filter) {
		
		if(!Strings.isNullOrEmpty(filter.getName())) {
			return repo.count(filter.getName()).intValue();
		}
		
		return count();
	}

	@Override
	public ProductCategoryData getById(@NonNull String id) {
		return ProductCategoryMapper.INSTANCE.toData(repo.getOne(id));
	}

	@Override
	public ProductCategoryData getByName(@NonNull String name) {
		return ProductCategoryMapper.INSTANCE.toData(repo.findOneByName(name));
	}

	@Override
	public List<ProductCategoryData> getAllProductCategorys() {
		return ProductCategoryMapper.INSTANCE.toDatas(repo.findAll());
	}

	@Override
	public List<ProductCategoryData> getAllProductCategorys(int page, int size) {
		return ProductCategoryMapper.INSTANCE.toDatas(repo.findAll(PageRequest.of(page, size)).getContent());
	}

	@Override
	public List<ProductCategoryData> getAllProductCategorys(@NonNull ProductCategoryFilter filter, int page, int size) {
		
		if(!Strings.isNullOrEmpty(filter.getName())) {
			
			return ProductCategoryMapper.INSTANCE.toDatas(repo.findAllByNameLike(filter.getName(), PageRequest.of(page, size)));
		}
		
		return getAllProductCategorys();
	}
}
