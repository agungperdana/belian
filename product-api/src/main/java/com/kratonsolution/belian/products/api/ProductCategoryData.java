package com.kratonsolution.belian.products.api;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Setter
public class ProductCategoryData implements Serializable
{
	private static final long serialVersionUID = 3248477087096147675L;

	private String name;
	
	private String comment;
	
	private Set<ProductCategoryData> childs = new HashSet<>();
}
