/**
 * 
 */
package com.kratonsolution.belian.payment.dm;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.sales.dm.PaymentApplication;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * 
 * A RECEIPT subtype represents incoming moneys to an internal organization of the enterprise.
 */
@Getter
@Setter
@Entity
@Table(name="receipt")
public class Receipt extends Payment
{
	@OneToMany(mappedBy="receipt",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<PaymentApplication> billings = new HashSet<>();
	
	public Receipt(){}

	@Override
	public BigDecimal getNetAmount()
	{
		return getAmount();
	}
}
