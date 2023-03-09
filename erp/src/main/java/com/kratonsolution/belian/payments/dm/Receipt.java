
package com.kratonsolution.belian.payments.dm;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="receipt")
public class Receipt extends Payment
{
	@Override
	public String getType()
	{
		return "IN";
	}

	@Override
	public BigDecimal getPaymentAmt()
	{
		return getAmount();
	}

}
