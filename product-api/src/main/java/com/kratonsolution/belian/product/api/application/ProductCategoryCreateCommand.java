package com.kratonsolution.belian.product.api.application;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */
@Getter
@Setter
public class ProductCategoryCreateCommand {

	@NonNull
	private String name;
	
	private String comment;
	
	private String parentName;
}
