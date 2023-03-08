/**
 * 
 */
package com.kratonsolution.belian.payments.dm;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="disbursement")
public class Disbursement extends Payment
{
	@Override
	public String getType()
	{
		return "OUT";
	}

	@Override
	public BigDecimal getPaymentAmt()
	{
		return getAmount().multiply(BigDecimal.valueOf(-1));
	}

}
