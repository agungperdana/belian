package com.kratonsolution.belian.product.api;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class UOMFactorData implements Serializable
{
	private static final long serialVersionUID = 4975155367401694531L;
	
	private BigDecimal value = BigDecimal.ZERO;

	private String from;
	
	private String to;

	public UOMFactorData(){}
}
