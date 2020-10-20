package com.kratonsolution.belian.product.api;

import java.io.Serializable;

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
	
	private ProductCategoryData parent;
	
}
