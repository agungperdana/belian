package com.kratonsolution.belian.product.api;

import java.io.Serializable;

import com.kratonsolution.belian.product.api.model.ProductIdentificationType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Setter	
public class ProductIdentificationData implements Serializable {

	private static final long serialVersionUID = -6775843181605186027L;

	private String code;

	private ProductIdentificationType type;
	
	private String comment;

	ProductIdentificationData(){}
}
