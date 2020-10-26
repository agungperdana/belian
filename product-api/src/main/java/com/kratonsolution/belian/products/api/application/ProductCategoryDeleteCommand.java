package com.kratonsolution.belian.products.api.application;

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
public class ProductCategoryDeleteCommand {

	@NonNull
	private String name;
}
